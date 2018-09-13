package main.java.study.concurrence.atomic.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * AtomicMarkableReference使用boolean值处理aba问题，
 * 但是处理不彻底，仍然会出现问题。慎用
 */
public class ABAMarkableDemo {
    static AtomicMarkableReference<Integer> atMarkRef =
            new AtomicMarkableReference<Integer>(100,false);

    static Thread t5 = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean mark=atMarkRef.isMarked();
            System.out.println("mark:"+mark);
            //更新为200
            System.out.println("t5 result:"+atMarkRef.compareAndSet(atMarkRef.getReference(), 200,mark,!mark));
        }
    });

    static Thread t6 = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean mark2=atMarkRef.isMarked();
            System.out.println("mark2:"+mark2);
            System.out.println("t6 result:"+atMarkRef.compareAndSet(atMarkRef.getReference(), 100,mark2,!mark2));
        }
    });

    static Thread t7 = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean mark=atMarkRef.isMarked();
            System.out.println("sleep 前 t7 mark:"+mark);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean flag=atMarkRef.compareAndSet(100,500,mark,!mark);
            System.out.println("flag:"+flag+",newValue:"+atMarkRef.getReference());
        }
    });

    public static  void  main(String[] args) throws InterruptedException {
        t5.start();t5.join();
        t6.start();t6.join();
        t7.start();

        /**
         * 输出结果:
         mark:false
         t5 result:true
         mark2:true
         t6 result:true
         sleep 前 t5 mark:false
         flag:true,newValue:500 ---->成功了.....说明还是发生ABA问题
         */
    }
}
