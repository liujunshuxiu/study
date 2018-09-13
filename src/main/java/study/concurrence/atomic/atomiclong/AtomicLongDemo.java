package main.java.study.concurrence.atomic.atomiclong;

public class AtomicLongDemo {

    public static void main(String[] args) {
        //没有并发数据问题时，最后会是100，但是并发时对象取值导致的问题会让结果到不了100
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Counter.addOne() == 100) {
                        System.out.println("计数器值最终值为100");
                    }
                }
            };
            thread.start();
        }
        System.out.println("long计算结束");
    }
}
