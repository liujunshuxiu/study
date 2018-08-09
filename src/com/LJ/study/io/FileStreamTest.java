package com.LJ.study.io;

import java.io.*;

public class FileStreamTest {
    private static final String FileName = "E:/study/LJStudy.txt";

    public static void main(String[] args) {
//        testFileOutputStream();
        testFileInputStream();
    }

    /**
     * FileOutputStream的API测试类
     */
    private static void testFileOutputStream() {
        try {
            // FileOutputStream fos = new FileOutputStream("fileStream.txt");
            // 创建文件对应File对象
            File file = new File(FileName);
            // 创建文件对应的FileOutputStream对象，默认是覆盖模式
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(new byte[] { 0x61, 0x62, 0x63, 0x64 });// abcd
            fos.write(new byte[] { 0x65, 0x66, 0x67, 0x68 });// efgh

            // 创建文件对应的FileOutputStream对象，默认是覆盖模式
            FileOutputStream fos2 = new FileOutputStream(file);
            fos2.write(new byte[] { 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78 });// qrstuvwx

            // 创建文件对应的FileOutputStream对象，模式为追加模式
            FileOutputStream fos3 = new FileOutputStream(file, true);
            fos3.write(new byte[] { 0x51, 0x52, 0x53, 0x54 });// QRST

            fos.close();
            fos2.close();
            fos3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * FileInputStream的API测试函数
     * qrstuvwxQRST
     */
    private static void testFileInputStream() {
        try {
            File file = new File(FileName);
            FileInputStream fis = new FileInputStream(file);

            FileDescriptor fd = fis.getFD();

            FileInputStream fis2 = new FileInputStream(fd);

            System.out.println("使用read()读取一个字节：" +(char)fis.read());

            System.out.println("使用available()获取当前可用字节数:" + fis.available());

            byte[] b = new byte[5];

            fis.read(b,0,b.length);

            System.out.println("使用readread(byte[] b,int off,int len)读取5个字节到b中:" + new String(b));

            System.out.println("使用available()获取当前可用字节数:" + fis.available());

            // 测试skip(long byteCount)
            System.out.printf("使用skip(long n)跳过%s个字节\n", fis.skip(1));

            System.out.println("使用available()获取当前可用字节数:" + fis.available());

            fis.close();
            fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
