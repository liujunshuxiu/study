package study.io.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender  extends Thread{
    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOutputStream(){
        return out;
    }

    @Override
    public void run(){
        writeMessage();
    }

    private void writeMessage() {
        String strInfo = "Hello World!";

        // 向管道输入流中写入数据
        try {
            out.write(strInfo.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
