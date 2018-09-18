package study.concurrence.lock.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = Thread.currentThread();
//        LockSupport.unpark(thread);
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("unpark finished");
//
//        LockSupport.park();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("park finished");
//
//        System.out.println("helloworld park");
//
//        //此时不会再进入
//        LockSupport.park();
//        System.out.println("park1 finished");
//        System.out.println("helloworld park1");


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
