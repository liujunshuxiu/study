package com.LJ.study.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 接收者线程
 */
public class Receiver extends Thread {
    private PipedInputStream in = new PipedInputStream();

    public PipedInputStream getInputStream(){
        return  in;
    }

    @Override
    public void run(){
        readMessage();
    }

    // 从管道输入流中读取数据
    public void readMessage(){
        byte[] buf = new byte[1024];
        try{
            int len = in.read(buf);
            //打印读取到的内容
            System.out.println(new String(buf, 0, len));
            //释放资源
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
