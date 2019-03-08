package study.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {

    static String fileName = "D:/临时/IOTest.txt";

    public static void main(String[] args){
        test();
    }

    /**
     * BufferedInputStream的API测试函数
     */
    private static void test() {
        try {

            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName), 10);

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
}
