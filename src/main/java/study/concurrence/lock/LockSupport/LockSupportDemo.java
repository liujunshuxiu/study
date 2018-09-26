package study.concurrence.lock.LockSupport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 用来创建锁和其他同步类的基本线程阻塞原语
 */
public class LockSupportDemo {
    
    public static void main(String[] args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();

        LockSupport.unpark(mainThread);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("unpark finished");

        LockSupport.park(mainThread);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("park finished");

        System.out.println("helloworld park");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park(mainThread);
                System.out.println("Thread park1 finished");

            }
        });
        thread2.start();
        thread2.join();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                LockSupport.unpark(mainThread);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread unpark1 finished");

            }
        });
        thread.start();
        System.out.println("helloworld park1");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "阻塞了");
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName() + "中断了");

                }
                System.out.println(Thread.currentThread().getName() + "运行了");

            }
        });
        t.start();
        t.interrupt();
        
    }
}
