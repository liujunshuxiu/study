package com.LJ.study.io.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 发送者线程
 */
public class Sender extends Thread {

    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOutputStream() {
        return out;
    }

    @Override
    public void run() {
        writeMessage();
    }

    // 向管道输出流中写入信息
    private void writeMessage() {
        String strInfo = "Hello World!";
        try {
            // 向管道输入流中写入数据
            out.write(strInfo.getBytes());
            // 释放资源
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
