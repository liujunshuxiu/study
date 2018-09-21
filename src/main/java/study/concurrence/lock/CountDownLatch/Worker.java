package study.concurrence.lock.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
    /**
     * CountDownLatch是一个通用同步器，用于同步一个或多个任务。在完成一组正在其他线程中执行的任务之前，它允许一个或多个线程一直等待。
     *
     * 可以用一个初始计数值来初始化CountDownLatch对象，任何在这个对象上调用wait()的方法都将阻塞，直至计数值到达0。每完成一个任务，都可以在这个对象上调用countDown()减少计数值。当计数值减为0，所有等待的线程都会被释放。CountDownLatch的计数值不能重置。如果需要重置计数器，请考虑使用CyclicBarrier。
     *
     * 使用场景
     *
     * 作为一个通用同步工具，CountDownLatch有许多用途。比如，将计数值初始化为1的CountDownLatch用作一个简单的开/关：在通过调用countDown()的线程打开入口前，所有调用await()的线程都一直在入口处等待；用N初始化的 CountDownLatch可以使一个线程在N个线程完成某项操作之前一直等待，或者使其在某项操作完成N次之前一直等待。
     */

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "启动了");
            startSignal.await();// 使当前线程在锁存器startSignal倒计数至零之前一直等待
            System.out.println(Thread.currentThread().getName() + "工作了");
            doneSignal.countDown();// 递减锁存器doneSignal的计数
        } catch (InterruptedException ex) {
        }
    }
}
