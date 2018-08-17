package com.LJ.study.concurrence.ticket;

/**
 * 错误示例，没有对tickets锁，导致数量判断异常
 */
public class TicketsWindow implements Runnable{

    private int tickets = 1;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "还剩余票:" + tickets + "张");
                tickets--;
                System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + tickets + "张");
            } else {
                System.out.println(Thread.currentThread().getName() + "余票不足,暂停出售!");
                try {
                    Thread.sleep(1000 * 60 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
