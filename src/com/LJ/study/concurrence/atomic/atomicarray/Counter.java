package com.LJ.study.concurrence.atomic.atomicarray;

import java.util.concurrent.atomic.AtomicLongArray;

public class Counter {
//    private static long[] counter = new long[]{0, 0, 0, 0, 0};
//
//    public static long[] addOne() {
//        for (int i = 0; i < counter.length; i++)
//            ++counter[i];
//        return counter;
//
//    }
//
//    public static long[] getCounter() {
//        return counter;
//    }
//
//    public static void setCounter(long[] counter) {
//        Counter.counter = counter;
//    }


    private static AtomicLongArray counter = new AtomicLongArray(new long[] {0, 0, 0, 0, 0});

    public static AtomicLongArray addOne() {
        for(int i=0;i<counter.length();i++)
            counter.incrementAndGet(i);
        return counter;
    }
}
