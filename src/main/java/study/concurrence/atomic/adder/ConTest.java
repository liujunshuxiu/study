package study.concurrence.atomic.adder;

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


}
