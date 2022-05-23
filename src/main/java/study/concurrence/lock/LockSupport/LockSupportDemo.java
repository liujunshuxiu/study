package study.concurrence.lock.LockSupport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 用来创建锁和其他同步类的基本线程阻塞原语
 * https://www.cnblogs.com/zhizhizhiyuan/p/4966827.html
 * 操作对象
 * 归根结底，LockSupport调用的Unsafe中的native代码：
 *
 * public native void unpark(Thread jthread);
 * public native void park(boolean isAbsolute, long time);
 * 两个函数声明清楚地说明了操作对象：park函数是将当前Thread阻塞，而unpark函数则是将另一个Thread唤醒。
 *
 * 与Object类的wait/notify机制相比，park/unpark有两个优点：1. 以thread为操作对象更符合阻塞线程的直观定义；2. 操作更精准，可以准确地唤醒某一个线程（notify随机唤醒一个线程，notifyAll唤醒所有等待的线程），增加了灵活性。
 *
 * 关于许可
 * 在上面的文字中，我使用了阻塞和唤醒，是为了和wait/notify做对比。其实park/unpark的设计原理核心是“许可”。park是等待一个许可。unpark是为某线程提供一个许可。如果某线程A调用park，那么除非另外一个线程调用unpark(A)给A一个许可，否则线程A将阻塞在park操作上。
 *
 * 有一点比较难理解的，是unpark操作可以再park操作之前。也就是说，先提供许可。当某线程调用park时，已经有许可了，它就消费这个许可，然后可以继续运行。这其实是必须的。考虑最简单的生产者(Producer)消费者(Consumer)模型：Consumer需要消费一个资源，于是调用park操作等待；Producer则生产资源，然后调用unpark给予Consumer使用的许可。非常有可能的一种情况是，Producer先生产，这时候Consumer可能还没有构造好（比如线程还没启动，或者还没切换到该线程）。那么等Consumer准备好要消费时，显然这时候资源已经生产好了，可以直接用，那么park操作当然可以直接运行下去。如果没有这个语义，那将非常难以操作。
 *
 * 其它细节
 * 理解了以上两点，我觉得应该把握了关键，其它细节就不是那么关键，也容易理解了，不作分析。
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
