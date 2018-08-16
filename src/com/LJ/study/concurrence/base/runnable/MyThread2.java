package com.LJ.study.concurrence.base.runnable;

public class MyThread2 implements Runnable{
    // 重写run方法
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "在运行");
        }
    }
}
