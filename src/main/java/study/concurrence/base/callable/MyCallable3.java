package main.java.study.concurrence.base.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception{
        return new Random().nextInt(100);
    }
}
