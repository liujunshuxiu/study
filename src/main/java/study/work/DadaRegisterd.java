package study.work;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DadaRegisterd {

    static String fileName = "C:/Users/admin-lj/Desktop/好未来日志/20200406.txt";

    static Set<String> phoneSet = new HashSet<String>();

    public static void main(String[] args){
        readFileByLines(fileName);
        
//        String str = "\"April 11th 2020, 00:06:33.998\",\"-tfXZHEBT03iKC5Pxh_3\",\"filebeat_api_weblog.2020.04.11\",,doc,\"public-php-api10\",\"public-php-api10\",\"6.2.3\",\"(DEFAULT)  2020-04-11 00:06:33 <I> haoweilai phone response: {\"\"errcode\"\":0,\"\"errmsg\"\":\"\"\\u8bf7\\u6c42\\u6210\\u529f\"\",\"\"data\"\":{\"\"phone_code\"\":\"\"86\"\",\"\"phone\"\":\"\"15187061713\"\"}} +203ms\",\"949,552\",\"/data0/logs/api.log\"";
//        System.out.println("length:"+str.length());
//        System.out.println("index:"+str.indexOf("\"\"phone\"\":\"\""));
//        System.out.println("phone:"+str.substring(str.indexOf("\"\"phone\"\":\"\"")+12,str.indexOf("\"\"phone\"\":\"\"")+23));
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            int index = 0;
            String phoneNum = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                index = tempString.indexOf("\"\"phone\"\":\"\"");
                phoneNum = tempString.substring(index+12,index+23);
//                System.out.println("line " + line + ": " + phoneNum);
                phoneSet.add(phoneNum);
                line++;
            }
            reader.close();
            System.out.println("phoneSet size :" + phoneSet.size());

            StringBuilder sb = new StringBuilder();
            phoneSet.forEach(moblie->sb.append("'").append(moblie).append("'").append(","));
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
