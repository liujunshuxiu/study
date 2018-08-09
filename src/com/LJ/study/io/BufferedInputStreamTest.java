package com.LJ.study.io;

import java.io.*;

public class BufferedInputStreamTest {

    private static String fileURL = "E:/study/LJStudy.txt";
    private static String fileOutURL = "E:/study/BufferedOut.txt";
    public static void main(String[] args) {
        testInput();
//        testOutPut();
    }

    /**
     * BufferedInputStream的API测试函数
     */
    private static void testInput() {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileURL), 10);

            int avail = in.available();
            System.out.println("可读字节数：" + avail);
            System.out.println("除最后十个字节外，读出所有字节");
            for (int i = 0; i < avail - 10; i++) {
                System.out.print(in.read() + ",");
            }
            System.out.println("\n可读字节数：" + in.available() + "\n");

            if (!in.markSupported()) {
                System.out.println("make/reset not supported!\n");
                return;
            } else
                System.out.println("make/reset supported!\n");

            in.mark(1024);
            System.out.println("使用skip方法跳过两个字节");
            in.skip(2);
            System.out.println("可读字节数：" + in.available());
            in.reset();
            System.out.println("执行reset方法后，可读字节数：" + in.available() + "\n");

            byte[] buf = new byte[5];
            in.read(buf, 0, 5);
            // 将buf转换为String字符串
            String str1 = new String(buf);
            System.out.println("读取的5个字节为" + str1);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testOutPut() {
        String content = "刘军是不是天才？";
        //刘军是不是天才？
        //必然是啊！

        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileOutURL));

            out.write(content.getBytes(),0,content.getBytes().length);

//            out.flush();//write方法会自动调用刷新
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
