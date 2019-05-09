package study.concurrence.sync;

public class AccountingSync1 implements Runnable{
    static AccountingSync1 instance = new AccountingSync1();
    static int i = 0;


    @Override
    public void run() {

        /**
         * 将synchronized作用于一个给定的实例对象instance，即当前实例对象就是锁对象，
         * 每次当线程进入synchronized包裹的代码块时就会要求当前线程持有instance实例对象锁，
         * 如果当前有其他线程正持有该对象锁，那么新到的线程就必须等待
         */
        synchronized (instance){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
