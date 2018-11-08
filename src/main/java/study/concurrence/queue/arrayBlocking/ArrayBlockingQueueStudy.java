package study.concurrence.queue.arrayBlocking;

import study.concurrence.condition.BoundedBuffer;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueStudy {

        public static void main(String[] args) {
            ArrayBlockingQueue<String> bb = new ArrayBlockingQueue(10);

            //新建写线程
            for (int i = 0; i < 60; i++) {
                final int finalI = i;
                Thread put = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("当前是写线程，编号" + finalI);
                        bb.add("当前是写线程，编号" + finalI);
                    }
                });
                put.start();
            }
            System.out.println(bb.size());

            //新建读线程
            for (int i = 0; i < 60; i++) {
                final int finalI = i;
                Thread take = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String s = (String) bb.take();
                            System.out.println("当前是读线程，编号" + finalI + "，读取结果：" + s);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                take.start();
            }

        }
}
