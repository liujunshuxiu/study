package study.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/**
 * 测试类
 */
public class PipedStreamTest {

    public static void main(String[] args) {
        Sender sender = new Sender();

        Receiver receiver = new Receiver();

        PipedOutputStream out = sender.getOutputStream();

        PipedInputStream in = receiver.getInputStream();

        try {
            // 连接输入流和输出流。下面两条语句的效果是一样。
            // out.connect(in);
            in.connect(out);

            sender.start();
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}