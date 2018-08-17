package com.LJ.study.concurrence.ticket;

public class SellTickets {

    /**
     * 错误示例，没有对tickets锁，导致数量判断异常
     */
    public static void main(String[] args) {
        TicketsWindow tw = new TicketsWindow();
        Thread t1 = new Thread(tw, "一号窗口");
        Thread t2 = new Thread(tw, "二号窗口");
        t1.start();
        t2.start();
    }
}
