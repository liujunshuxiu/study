package main.java.study.io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

    static byte[] buf = new byte[]{2, 15, 67, -1, -9, 9};

    public static void main(String[] args){
        test4();
    }
    private static void test1(){
//        ByteArrayInputStream bais = new ByteArrayInputStream(buf,1,4);
//        int b;
//        while ((b = bais.read()) != -1){
//            System.out.println(b + ",");
//        }
//        System.out.println("\n--------------------");
        int b;
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        bais.skip(2);
        while ((b = bais.read()) != -1){
            System.out.println(b + ",");
        }

    }

    public static void test4() {
        // 2, 15, 67, -1, -9, 9
        // 默认标记值为0
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        System.out.println(bais.markSupported());
        System.out.println(bais.read());
        bais.reset();
        System.out.println(bais.read());

        System.out.println("******************");

        // mark()的参数没有意义
        bais.mark(4);
        while (bais.read() != -1) {
        }
        bais.reset();
        System.out.println(bais.read());

    }
}
