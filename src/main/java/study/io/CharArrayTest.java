package main.java.study.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayTest {


    public static void main(String[] args) {
//        tesCharArrayReader();
        testCharArrayWriter();
    }



    public static void tesCharArrayReader() {
        try {
            CharArrayReader reader = new CharArrayReader(
                    new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'});

            // 从reader中连续读取三个字节
            for (int i = 0; i < 3; i++) {
                if (reader.ready() == true) {
                    char tmp = (char) reader.read();
                    System.out.println(tmp);
                }
            }

            System.out.println();

            // 测试是否支持mark
            if (!reader.markSupported()) {
                System.out.println("make not supported!");
                return;
            } else
                System.out.println("make supported!");

            // 标记，当前位置为d
            reader.mark(0);
            // 跳过2个字符，当前位置为f
            reader.skip(2);

            // 向下读取两个字符，fg
            char[] buf = new char[2];
            reader.read(buf, 0, 2);
            System.out.println("buf:" + String.valueOf(buf));

            // 重置当前位置为上一次标记的位置，即为d
            reader.reset();


            // 向下读取两个字符，de
            reader.read(buf, 0, 2);
            System.out.println("buf:" + String.valueOf(buf));

            // 关闭后，在调用方法，会抛出“java.io.IOException: Stream closed”异常
            reader.close();
            reader.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static final char[] charArr = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g'};


    /**
     * CharArrayWriter的API测试函数
     */
    public static void testCharArrayWriter() {
        try {
            // 创建CharArrayWriter字符流,默认大小为32
            CharArrayWriter writer = new CharArrayWriter();

            writer.write('A');
            writer.write("BCDEF");
            writer.write(charArr, 1, 3);
            System.out.println("写入字符A，写入字符串BCDEF，写入charArr中从索引位置1开始的三个字符，即bcd，此时的writer为：\n" + writer);

            writer.append('0').append("12345").append(String.valueOf(charArr), 3, 6);
            System.out.println("写入字符0，写入字符串12345，写入charArr中从索引位置3到5的三个字符，即def，此时的writer为：\n" + writer);

            System.out.println("此时writer的大小为：\n" + writer.size());

            char[] buf = writer.toCharArray();
            System.out.println("将writer转化为字符数组再将其打印：\n" + String.valueOf(buf));

            // 创建CharArrayWriter字符流,指定大小为100
            CharArrayWriter writer2 = new CharArrayWriter(100);
            writer.writeTo(writer2);
            System.out.println("将writer缓冲区内容写入到wirter2中，writer缓冲区内容为：\n" + writer2);

            writer.reset();
            System.out.println("将writer重置，此时其缓冲区为:\n" + writer);

            writer2.close();
            System.out.println("将writer2关闭，调用其size方法，结果为:\n" + writer2.size());
            System.out.println("如果没有抛出异常，说明其close方法没有作用。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
