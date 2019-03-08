package study.io;

import java.io.*;

public class LJIOTest {

    private static String UTF8URL = "C:/临时/CCTV1（高清）.txt";
//    private static String GBKURL = "C:/临时/CCTV-2财经.txt";
    private static String ANSIURL = "C:/临时/CCTV-2财经ANSI.txt";

    public static void main(String[] args){

//        String fileName = "C:/临时/IOTest.txt";
        readFileByLines(ANSIURL);
    }



    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件InputStream
     */
    public static void readFileByLines(String fileName) {
        BufferedReader reader = null;
        try {
            File file = new File(UTF8URL);
            FileInputStream in = new FileInputStream(file);
            byte[] b = new byte[3];
            in.read(b);
            String code = "GBK";
            if (b[0] == -17 && b[1] == -69 && b[2] == -65) {
                code = "UTF-8";
            }

            InputStreamReader inputStreamReader = new InputStreamReader(in, code);
            reader = new BufferedReader(inputStreamReader);


            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new FileReader(file));
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"GBK"));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
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
