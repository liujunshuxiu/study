package study.concurrence.atomic.atomiclong;

import java.util.concurrent.atomic.AtomicLong;

class Counter extends Thread {

    //错误方式，会出现多线程异常
//    private static long counter = 0;
//
//    public static long addOne() {
//        return ++counter;
//    }


    //使用原子类去更新
    private static AtomicLong counter = new AtomicLong(0);

    public static long addOne() {
//        AtomicLong counter = new AtomicLong(0);
        return counter.incrementAndGet();
    }

//    private volatile long counter = 0;
//
//    static AtomicLongFieldUpdater updater = AtomicLongFieldUpdater.newUpdater(Counter.class, "counter");
//    static Counter safeCounter = new Counter ();
//
//    public static long addOne() {
//        return updater.addAndGet(safeCounter, 1);
//    }
}