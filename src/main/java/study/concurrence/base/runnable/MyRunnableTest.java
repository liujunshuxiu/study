package main.java.study.concurrence.base.runnable;

public class MyRunnableTest {
//    public static void main(String[] args){
//        MyThread2 mt = new MyThread2();
//        Thread t1 = new Thread(mt);
//        Thread t2 = new Thread(mt);
//
//        t1.start();
//        t2.start();
//
//    }

    public static void main(String[] args){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //启动线程
//        t1.start();
        t1.run();
//        t2.start();
        t2.run();//直接调用run并没有启动新的现场，仍在main线程中。

        for (int i = 0; i < 3; i++)
        {
            System.out.println(Thread.currentThread().getName() + "在运行");
        }

    }

}
