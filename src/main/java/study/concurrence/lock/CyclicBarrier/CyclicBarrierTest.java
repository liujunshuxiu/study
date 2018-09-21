package study.concurrence.lock.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier允许一组线程互相等待，直到到达某个公共屏障点。如果你希望一组并行的任务在下个步骤之前相互等待，直到所有的任务都完成了下个步骤前的所有操作，才继续向前执行，那么CyclicBarrier很合适。
 */
public class CyclicBarrierTest {
    // 参与者数量
    private static int parties = 3;
    // 创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动
    private static CyclicBarrier barrier = new CyclicBarrier(parties);

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "await");
                // 在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
                barrier.await();
                System.out.println(Thread.currentThread().getName() + "continued");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < parties; i++){
            new Thread(new Task()).start();
        }
        Thread.sleep(1000);
        System.out.println("getNumberWaiting()：" + barrier.getNumberWaiting());
    }

}
