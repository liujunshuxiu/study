package study.concurrence.atomic.adder;

import study.concurrence.atomic.atomicIntegerArray.AtomicIntegerArrayDemo;

import java.util.concurrent.atomic.LongAdder;

public class ConTest {

    private static LongAdder counter = new LongAdder();


    public static long addOne() {
        counter.add(1);
        System.out.println("counter.sum():"+counter.sum());
        return counter.sum();
    }

    public static LongAdder getCounter() {
        return counter;
    }

    public static class AddThread implements Runnable{
        public void run(){
            for(int k=0;k<999999;k++)
                //执行数组中元素自增操作,参数为index,即数组下标
                counter.add(k);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[100];

        for(int k = 0 ; k < 100;k++){
            ts[k] = new Thread(new ConTest.AddThread());
        }

        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        System.out.println(counter.sum());
    }
}
