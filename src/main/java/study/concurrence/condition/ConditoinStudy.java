package study.concurrence.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ConditoinStudy {
    static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        Condition condition=lock.newCondition();

        new Thread(() ->{
            lock.lock();
            try{
                System.out.println("线程一加锁成功");
                System.out.println("线程一挂起成功");
                condition.await();
                System.out.println("线程一唤醒成功");
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
                System.out.println("线程一释放锁成功");
            }
        }).start();
        new Thread(() ->{
            lock.lock();
            try{
                System.out.println("线程二加锁成功");
                condition.signal();
                System.out.println("线程二唤醒线程一");
            }finally {
                lock.unlock();
                System.out.println("线程二释放锁成功");
            }
        }).start();
    }

}
