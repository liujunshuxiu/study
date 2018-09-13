package main.java.study.concurrence.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class TicketWindow implements Runnable {

    private int tickets = 100;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "还剩余票:" + tickets + "张");
                    --tickets;
                    System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + tickets + "张");
                } else {
                    System.out.println(Thread.currentThread().getName() + "余票不足,暂停出售!");
                }
                try {
                    Thread.sleep(1000 * 6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
            System.out.println("释放锁!");
            try {
                Thread.sleep(1000 * 6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("释放锁后睡眠结束!");
        }
    }
}
