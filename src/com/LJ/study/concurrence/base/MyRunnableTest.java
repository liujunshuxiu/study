package com.LJ.study.concurrence.base;

public class MyRunnableTest {
    public static void main(String[] args){
        MyThread2 mt = new MyThread2();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);

        t1.start();
        t2.start();

    }
}
