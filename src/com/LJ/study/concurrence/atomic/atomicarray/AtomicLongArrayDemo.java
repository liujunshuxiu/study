package com.LJ.study.concurrence.atomic.atomicarray;

import java.util.Arrays;

public class AtomicLongArrayDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    if(("[100, 100, 100, 100, 100]").equals(Arrays.toString(Counter.addOne())))
                    if(("[100, 100, 100, 100, 100]").equals(Counter.addOne().get(1)))
                        System.out.println("计数器值最终值为[100, 100, 100, 100, 100]");
                }
            };
            thread.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("处理完毕后，counter值为："+Arrays.toString(Counter.getCounter()));
    }
}
