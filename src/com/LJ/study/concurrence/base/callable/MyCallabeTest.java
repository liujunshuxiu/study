package com.LJ.study.concurrence.base.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallabeTest {
    
    public static void main(String[] args){
        Callable<String> callable = new MyCallable();
        FutureTask<String> task = new FutureTask<>(callable);

        new Thread(task).start();
        String result = null;
        try{

            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("return : " + result);

    }
}
