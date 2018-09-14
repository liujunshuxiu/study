package study.concurrence.base.runnable;

public class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行");
        }
    }
}
