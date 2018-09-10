package com.LJ.study.concurrence.sync;

public class AccountingSync implements Runnable {

    //共享资源(临界资源)
    static int i=0;

    /**
     * synchronized 修饰实例方法
     * 线程的锁便是实例对象instance
     */
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance=new AccountingSync();

        Thread t1=new Thread(instance);
//        Thread t2=new Thread(instance);

        Thread t2=new Thread(new AccountingSync()); //new新实例,会出现异常,因为sync实例方法只能作用于同一个实例
                                                    //存在着两个不同的实例对象锁

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
