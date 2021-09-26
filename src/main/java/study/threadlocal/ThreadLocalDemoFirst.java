package study.threadlocal;

/**
 * 参考：https://www.cnblogs.com/cqqfboy/p/14497887.html
 */
public class ThreadLocalDemoFirst {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Long []> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 50; i++) {
            run(threadLocal);
        }
        Thread.sleep(50000);
        // 去除强引用
        threadLocal = null;
        System.gc();
        System.runFinalization();
        System.gc();
    }

    private static void run(ThreadLocal<Long []> threadLocal) {
        new Thread(() -> {
            threadLocal.set(new Long[1024 * 1024 *10]);
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
