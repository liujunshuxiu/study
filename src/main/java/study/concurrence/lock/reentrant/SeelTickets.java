package study.concurrence.lock.reentrant;

public class SeelTickets {
    public static void main(String[] args){
        TicketWindow tw = new TicketWindow();
        Thread t1 = new Thread(tw,"1号窗口");
        Thread t2 = new Thread(tw,"2号窗口");
        t1.start();
        t2.start();

    }
}
