package study.concurrence.sync;

public class AccountingSync1 implements Runnable{
    static AccountingSync1 instance = new AccountingSync1();
    static int i = 0;


    @Override
    public void run() {
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
