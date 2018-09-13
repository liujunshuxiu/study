package main.java.study.concurrence.base.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallabeTest3 {
    public static void main(String[] args){
        //创建线程执行器
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //创建Future类型的集合
        List<Future<Integer>> results = new ArrayList<Future<Integer>>();
        //将Executor提交的任务的返回值添加到集合中
        for(int i = 0;i<5;i++)
            results.add(threadPool.submit(new MyCallable3()));

        //遍历集合取出数据
        try {
            // 调用get()阻塞主线程，并获取返回值
            for(Future result : results)
                System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally{
            threadPool.shutdown();
        }


    }
}
