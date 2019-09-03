package study.leetcode.thread.zero;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd2 {

    private int n;
    private volatile int num = 1;

    private Semaphore semp0 = new Semaphore(1);
    private Semaphore sempOdd = new Semaphore(0);
    private Semaphore sempEven = new Semaphore(0);

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0 ; i < n ;i++){
            semp0.acquire();
            printNumber.accept(0);
            if(num % 2 == 1){
                sempOdd.release();
            }else if(num % 2 == 0){
                sempEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(;;){
            sempEven.acquire();
            if(num <= n){
                printNumber.accept(num);
                num++;
                semp0.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(;;){
            sempOdd.acquire();
            if(num <= n){
                printNumber.accept(num);
                num++;
                semp0.release();
            }
        }
    }

}
