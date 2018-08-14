package com.LJ.study.io;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamTest {

    public static void main(String[] args){
        test1();
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


}
