package com.LJ.study.concurrence.base.runnable;

public class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(this.getName() + "在运行");
        }
    }
}
