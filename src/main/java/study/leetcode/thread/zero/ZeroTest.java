package study.leetcode.thread.zero;


public class ZeroTest {
    public static void main(String[] args){
//        ZeroEvenOdd zero = new ZeroEvenOdd(5);
        ZeroEvenOdd2 zero = new ZeroEvenOdd2(5);
        IntConsumer consumer = new IntConsumerImpl();

        Thread thread1 =new Thread(()-> {
            try {
                zero.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()-> {
            try {
                zero.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()-> {
            try {
                zero.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
