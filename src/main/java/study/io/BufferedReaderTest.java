package main.java.study.io;

import java.io.*;

public class BufferedReaderTest {

    private static String bufferURL = "C:/临时/bufferRead.txt";
    private static String bufferWriteURL = "C:/临时/bufferWrite.txt";

    public static void main(String[] args){
//        testRead();
        testWrite();
    }
    public static void testRead() {
        try {
            File file = new File(bufferURL);
            BufferedReader in = new BufferedReader(new FileReader(file));

            System.out.println("从缓冲区中读取5个字符，并打印");
            
            for(int i= 0 ; i< 5 ;i++){
                if(in.ready()){
                    int tmp = in.read();
                    System.out.println(i + ":" + (char) tmp);
                }
            }

            char[] buf = new char[3];
            in.read(buf,0,3);

            System.out.println("从缓冲区中读取三个字符存到字符数组中，字符数组内容为" + String.valueOf(buf));
            System.out.println("当前行剩余字符为" + in.readLine());

            System.out.println("测试BufferedReader是否支持标记");

            if (!in.markSupported()) {
                System.out.println("make not supported!");
                return;
            }
            System.out.println("make supported!");

            System.out.println("测试标记功能（当前位置的下个字符为A）");
            in.mark(1024);
            System.out.println("跳过22个字符");
            in.skip(22);
            System.out.println("当前位置为" + (char) in.read());
            System.out.println("重置输入流的索引为mark()所标记的位置，即重置到f处");
            in.reset();
            System.out.println("当前位置为" + (char) in.read());

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void testWrite() {
        try {
            File file = new File(bufferWriteURL);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(new char[] { 'a', 'b', 'c', 'd', 'e' }, 0, 3);
            writer.newLine();
            writer.write("ABCDEFGHIJKLMN", 0, 3);
            writer.newLine();
            writer.write('\n');
            writer.write(1200);

            writer.flush();

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
