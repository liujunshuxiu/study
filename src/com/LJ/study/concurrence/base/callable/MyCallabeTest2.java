package com.LJ.study.concurrence.base.callable;

import java.util.concurrent.*;

public class MyCallabeTest2 {

    public static void main(String[] args){
        Callable<String> callable = new MyCallable();
        //创建线程执行器
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //通过线程执行器执行callable，并通过future获取返回结果
        Future<String> future = threadPool.submit(callable);

        String result = null;
        try{

            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("return : " + result);

    }
}
