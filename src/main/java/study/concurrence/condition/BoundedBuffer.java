package main.java.study.concurrence.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();//写条件
    final Condition notEmpty = lock.newCondition();//读条件

    final Object[] items = new Object[5];
    int putptr, takeptr, count;

    public void put(Object x) {
        lock.lock();
        try {
        while (count == items.length) {
            notFull.await();
        }
        items[putptr] = x;
        if(++putptr == items.length)
            putptr = 0;
        ++count;
        notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)//如果队列已空
                notEmpty.await();//阻塞读线程
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            notFull.signal();//唤醒写线程
            return x;
        } finally {
            lock.unlock();
        }
    }
}
