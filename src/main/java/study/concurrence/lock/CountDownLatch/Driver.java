package study.concurrence.lock.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Driver {
    public static void main(String args[]) throws InterruptedException {
        int n = 5;
        // 启动信号，在driver为继续执行worker做好准备之前，它会阻止所有的worker继续执行。
        CountDownLatch startSignal = new CountDownLatch(1);
        // 完成信号，它允许driver在完成所有 worker之前一直等待。
        CountDownLatch doneSignal = new CountDownLatch(n);

        for (int i = 0; i < n; ++i){
            new Thread(new Worker(startSignal, doneSignal)).start();
        } // 创建并启动所有线程
        Thread.sleep(1000);

        startSignal.countDown(); // 打开startSignal开关，执行所有等待的任务

        doneSignal.await();// 等待doneSignal计数器为0，即所有任务执行完

        System.out.println("down");
    }
}
