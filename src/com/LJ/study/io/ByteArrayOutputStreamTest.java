package com.LJ.study.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {

    public static void main(String[] args){
        test4();
    }

    public static void test1(){
        int a = 0;
        int b = 1;
        int c = 2;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(a);
        baos.write(b);
        baos.write(c);
        byte[] buf = baos.toByteArray();
        for (int i = 0; i < buf.length; i++)
            System.out.print(buf[i] + ",");
    }


    public static void test4()  {
        byte[] buf = new byte[] { 2, 15, 67, -1, -9, 9 };
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buf = baos.toByteArray();
        for (int i = 0; i < buf.length; i++)
            System.out.print(buf[i] + ",");
        System.out.println("\n*************");
        baos.reset();
        buf = baos.toByteArray();
        System.out.println(buf.length);
    }
}
