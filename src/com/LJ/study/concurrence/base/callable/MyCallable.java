package com.LJ.study.concurrence.base.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    public String call() throws Exception{
        return "This is returned string.";
    }
}
