package study.concurrence.threadLocal;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadLocalStudy {

    /*设置一个信号量，许可数为1，让三个线程顺序执行*/
    Semaphore semaphore = new Semaphore(1);

    private Random rnd = new Random();

    public class Worker implements Runnable{
        @Override
        public void run(){

            try {
                Thread.sleep(rnd.nextInt(1000)); /*随机延时1s以内的时间*/
                semaphore.acquire();/*获取许可*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            InvocationInfoProxy.setUserid("initUser");
            InvocationInfoProxy.setTenantid("initTenant");
            String valA = InvocationInfoProxy.getUserid();
            System.out.println(Thread.currentThread().getName() +" tlA initial val : "+ valA);
            valA = valA + rnd.nextInt();
            InvocationInfoProxy.setUserid(valA);
            System.out.println(Thread.currentThread().getName() +" tlA  new     val: "+ valA);

            /*
            int valB = tlB.get();
            System.out.println(Thread.currentThread().getName() +" tlB initial val : "+ valB);
            valB = rnd.nextInt();
            tlA.set(valB);
            System.out.println(Thread.currentThread().getName() +" tlB 2    new val: "+ valB);
            */

            semaphore.release();

            /*在线程池中,当线程退出之前一定要记得调用remove方法，因为在线程池中的线程对象是循环使用的*/
            InvocationInfoProxy.reset();
            /*tlB.remove();*/
        }
    }

    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(3);
        ThreadLocalStudy tld = new ThreadLocalStudy();
        es.execute(tld.new Worker());
        es.execute(tld.new Worker());
        es.execute(tld.new Worker());
        es.shutdown();
    }
}
