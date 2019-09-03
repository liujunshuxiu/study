package study.leetcode.thread.zero;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {

    private int n;

    private Semaphore semp0 = new Semaphore(1);
    private Semaphore sempOdd = new Semaphore(0);
    private Semaphore sempEven = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1 ; i <= n ;i++){
            semp0.acquire();
            printNumber.accept(0);
            if(i % 2 == 1){
                sempOdd.release();
            }else if(i % 2 == 0){
                sempEven.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2 ; i <= n ;i=i+2){
            sempEven.acquire();
                printNumber.accept(i);
                semp0.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1 ; i <= n ;i=i+2){
            sempOdd.acquire();
            printNumber.accept(i);
            semp0.release();
        }

    }

}
