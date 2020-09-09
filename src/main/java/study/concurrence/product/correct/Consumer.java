package study.concurrence.product.correct;

import java.util.List;

public class Consumer extends Thread {
    List<Object> container;
    /*表示当前线程共生产了多少件物品*/
    private int count;

    public Consumer(String name, List<Object> container) {
        super(name);
        this.container = container;
    }

    @Override
    public void run() {

        while(true){
            synchronized (container) {
                try {
                    if (container.isEmpty()) { //仓库已空，不能消 只能等
                        container.wait(20);

                    } else {
                        // 消费
                        container.remove(0);
                        this.count++;
                        System.out.println("消费者：" + getName() + " 共消费了：" + this.count + "件物品，当前仓库里还有" + container.size() + "件物品");
                        container.notifyAll();  // 唤醒等待队列中所有线程
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}