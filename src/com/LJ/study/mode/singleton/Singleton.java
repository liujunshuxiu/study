package com.LJ.study.mode.singleton;

/**
 * 双重锁
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton (){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    
}
