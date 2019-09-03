package study.leetcode.thread.zero;

public class IntConsumerImpl implements IntConsumer{
    @Override
    public void accept(int i) {
        System.out.println(Thread.currentThread().getName() +":i = "+i);
    }
}
