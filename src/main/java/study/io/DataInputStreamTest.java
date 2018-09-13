package main.java.study.io;

import java.io.*;

public class DataInputStreamTest {

    private static String fileURL = "E:/study/LJStudy.txt";
    public static void main(String[] args) {
        testDataOutputStream();
        testDataInputStream();
    }

    /**
     * DataOutputStream的API测试函数
     */
    private static void testDataOutputStream() {

        try {
            File file = new File(fileURL);
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

            out.writeBoolean(true);
            out.writeByte(122);
            out.writeChar('b');
            out.writeShort(123);
            out.writeInt(1111);
            out.writeLong(1233442L);

            out.writeUTF("DataOutputStream");

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * DataInputStream的API测试函数
     */
    private static void testDataInputStream() {

        try {
            File file = new File(fileURL);
            DataInputStream in = new DataInputStream(new FileInputStream(file));

            System.out.printf("readBoolean():%s\n", in.readBoolean());
            System.out.printf("readByte():%s\n", in.readByte());
            System.out.printf("readChar():%s\n", in.readChar());
            System.out.printf("readShort():%s\n", in.readShort());
            System.out.printf("readInt():%s\n", in.readInt());
            System.out.printf("readLong():%s\n", in.readLong());
            System.out.printf("readUTF():%s\n", in.readUTF());

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

