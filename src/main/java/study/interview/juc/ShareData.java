package study.interview.juc;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import study.concurrence.lock.reentrant.duck.ResourceByCondition;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 生产者消费者模式示例代码
 */
public class ShareData {

    private int num = 0;


    static class ProduceDemo implements Runnable{

        private ResourceByCondition r;

        public ProduceDemo(ResourceByCondition r){
           this.r = r;
        }

        @Override
        public void run() {
            while (true){
                r.product("烤鸭");
            }
        }
    }

    static class CustomerDemo implements Runnable{

        private ResourceByCondition r;

        public CustomerDemo(ResourceByCondition r){
            this.r = r;
        }

        @Override
        public void run() {
            while (true){
                r.consume();
            }
        }
    }

    public static void main(String[] args) {
        ResourceByCondition r = new ResourceByCondition();
        ProduceDemo produceDemo = new ProduceDemo(r);
        CustomerDemo customerDemo = new CustomerDemo(r);

        Thread thread0 = new Thread(produceDemo);
        Thread thread1 = new Thread(produceDemo);
//        Thread thread2 = new Thread(customerDemo);
//        Thread thread3 = new Thread(customerDemo);

        thread0.start();
        thread1.start();
//        thread2.start();
//        thread3.start();

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(2);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("customer:");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        executor.execute(customerDemo);
        executor.execute(customerDemo);
        executor.execute(customerDemo);
    }
}
