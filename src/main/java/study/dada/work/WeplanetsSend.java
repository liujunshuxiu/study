package study.dada.work;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.*;

public class WeplanetsSend {

    private static final String fileCodeURL = "E:/temporary/code.txt";
    private static final String fileStudentIdURL = "E:/temporary/studentId.txt";
    private static final String fileResultURL = "E:/temporary/result.txt";
    //dev-http://192.168.170.10,staging-http://192.168.5.10，production-http://192.168.5.3
    private static final String messageSendUrl = "http://10.1.132.203:10200/";
    //短信模板id
    private static final int tplId = 123;
    //短链
    private static final String shortURL = "https://www.baidu.com/";
    //【DaDa英语】官方合作，点击{{.short_url}}，输入兑换码{{.code}}获《童行学院·时空之旅》年卡，开启多学科视野培养自主能力！

    /**
     * @param tplId      的消息模板id
     * @param mobile     接收者的手机号,字符串格式,多个手机号使用 "," 分隔
     * @param tplDataMap 消息模板的数据,消息模板中定义的键值对
     */
    public static String sendSmsMessage(int tplId, String mobile, Map<String, String> tplDataMap) {
        String url = messageSendUrl + "/message.sms.send?pretty";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("tplId", String.valueOf(tplId));
        requestMap.put("chan", "aliyun");
        requestMap.put("tplData", JSON.toJSONString(tplDataMap));
        requestMap.put("mobile", mobile);

        String responseStr = HttpUtil.httpPostRequest(url, requestMap);
        return responseStr;
    }

    public static Map<Integer, String> readMobile(Set<Integer> studentIds) throws SQLException {

        StringBuilder sb = new StringBuilder();
        sb.append("select id,s_mobile from student where id in (")
                .append(StringUtils.join(studentIds, ","))
                .append(");");

        Map<Integer, String> studentMap = (Map<Integer, String>) JDBCUtil.query(sb.toString());
        return studentMap;
    }

    public static void main(String[] args) {
        //读取兑换码
        List<String> codeLines = FileUtil.readFromFile(fileCodeURL);
        //读取学生id
        List<String> studentIdlines = FileUtil.readFromFile(fileStudentIdURL);

        //todo 给初始size值
        Set<Integer> studentIds = new HashSet<>();
//        Set<String> codes = new HashSet<>();
        List<String> codeList = new ArrayList<>();

        for (String line : studentIdlines) {
            if (Strings.isNullOrEmpty(line)) {
                continue;
            }
            studentIds.add(Integer.valueOf(line));
        }

        for (String line : codeLines) {
            if (Strings.isNullOrEmpty(line)) {
                continue;
            }
            codeList.add(line);
        }

        Map<Integer, String> studentMap = null;
        try {
            studentMap = readMobile(studentIds);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("student num：%d,codes num:%d", studentMap.size(), codeList.size()));


        int num = 0;
        StringBuilder smsResult = new StringBuilder();
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            String codeDetail = codeList.get(num);
            Map<String, String> tplDataMap = new HashMap<>();
            tplDataMap.put("short_url", shortURL);
            tplDataMap.put("code", codeDetail);
//            String result = sendSmsMessage(tplId, entry.getValue(), tplDataMap);

//            JSONObject resultObj = JSONObject.parseObject(result);
            JSONObject resultObj = new JSONObject();
            resultObj.put("taskNum",1);
            resultObj.put("ctime",System.currentTimeMillis());
            if (resultObj.getInteger("taskNum") != null && resultObj.getInteger("taskNum").intValue() > 0) {
                //请求成功，记录关系
                smsResult.append(entry.getKey()).append(",")
                        .append(entry.getValue()).append(",")
                        .append(codeDetail).append(",")
                        .append(resultObj.getInteger("ctime")).append("\r\n");
                num++;
            }
        }
        System.out.println("end");
        FileUtil.write2File(fileResultURL, smsResult.toString());
    }

    /**
     * 文件处理工具类
     */
    public static class FileUtil {
        /**
         * 文件读取
         *
         * @param fileName
         * @return
         */
        public static List<String> readFromFile(String fileName) {
            List<String> lines = new ArrayList<String>();

            try {
                File file = new File(fileName);
                lines = Files.readLines(file, Charsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return lines;
        }


        /**
         * 向文件中写入字节流
         *
         * @param fileName 要写入文件的文件名
         * @param contents 要写入的文件内容
         */
        public static void write2File(String fileName, String contents) {
            File newFile = new File(fileName);
            try {

                Files.append(contents, newFile, Charsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 简单http工具类
     */
    public static class HttpUtil {

        private static String POST = "POST";
        private static String GET = "GET";
        private static String CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded";
        private static String CONTENT_TYPE_JSON = "application/json";

        private static String httpRequest(String method, String contentType, String urlStr, Map<String, String> paras)
                throws IOException {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", CONTENT_TYPE_JSON);

            if (paras != null && !paras.isEmpty()) {
                con.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                out.writeBytes(ParameterStringBuilder.getJsonString(paras));
                out.flush();
                out.close();
            }


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();
        }

        private static class ParameterStringBuilder {
            public static String getParamsString(Map<String, String> params)
                    throws UnsupportedEncodingException {
                StringBuilder result = new StringBuilder();

                for (Map.Entry<String, String> entry : params.entrySet()) {
                    result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    result.append("=");
                    result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    result.append("&");
                }

                String resultString = result.toString();
                return resultString.length() > 0
                        ? resultString.substring(0, resultString.length() - 1)
                        : resultString;
            }

            public static String getJsonString(Map<String, String> params) {
                return JSON.toJSONString(params);
            }
        }


        public static String httpGetRequest(String url) {
            try {
                return httpRequest(GET, CONTENT_TYPE_URLENCODED, url, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public static String httpPostRequest(String url, Map<String, String> paras) {
            try {
                return httpRequest(POST, CONTENT_TYPE_JSON, url, paras);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    /**
     * 数据库查询工具
     */
    public static class JDBCUtil {

        public static Object query(String sql) throws SQLException {
            String url = "jdbc:mysql://182.92.214.45:3306/lj_test_1";
            String username = "root";
            String password = "c147258369C@";

            Connection con = null; //一个封装了TCP长连接 的 数据库长连接对象
            ResultSet rSet = null; //一个封装了数据对象 的 无序集合对象

            try {
                con = DriverManager.getConnection(url, username, password);

                PreparedStatement prepareStatement = con.prepareStatement(sql);

                rSet = prepareStatement.executeQuery();

                Map<Integer, String> studentMap = new HashMap<>();
                while (rSet.next()) {
                    System.out.println(rSet.getString(1) + " " + rSet.getString(2));
                    studentMap.put(rSet.getInt(1), rSet.getString(2));
                }

                return studentMap;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rSet != null) {
                    rSet.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            return null;
        }
    }
}
