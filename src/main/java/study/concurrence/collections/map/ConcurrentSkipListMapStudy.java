package study.concurrence.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapStudy {

    private static Map<String, String> mMap = new ConcurrentSkipListMap<String, String>();


    public static class AddThread implements Runnable{
        public void run(){
            for(int k=0;k<999999;k++)
                //执行数组中元素自增操作,参数为index,即数组下标
                mMap.put(Thread.currentThread().getName()+k+"",k+"");
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread[] ts = new Thread[10];

        for(int k = 0 ; k < 100;k++){
            ts[k] = new Thread(new ConcurrentSkipListMapStudy.AddThread());
        }

        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        System.out.println(mMap.size());
    }
}
