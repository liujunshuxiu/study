package study.concurrence.product.correct;

import java.util.List;

public class Producer extends Thread{

    List<Object> container;
    /*表示当前线程共生产了多少件物品*/
    private int count;

    public Producer(String name, List<Object> container) {
        super(name);
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (container) {
                try {
                    // 如果某一个生产者能执行进来，说明此线程具有container对象的控制权,其它线程（生产者&消费者）都必须等待
                    if (container.size() == 10) { // 假设container最多只能放10个物品，即仓库已满
                        container.wait(10); //表示当前线程需要在container上进行等待
                    } else {
                        // 仓库没满，可以放物品
                        container.add(new Object());
                        this.count++;
                        System.out.println("生产者：" + getName() + " 共生产了：" + this.count + "件物品，当前仓库里还有" + container.size() + "件物品");
                        // 生产者生产了物品后应通知（唤醒）所有在container上进行等待的线程（生产者&消费者）
                        //   生：5， 消：5
                        // container.notify();  // 随机唤醒一个在等待队列中的线程
                        container.notifyAll();  // 唤醒等待队列中所有线程
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } //

            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}