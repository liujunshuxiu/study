package main.java.study.concurrence.condition;

public class BoundedTest {

    public static void main(String[] args){
        BoundedBuffer bb = new BoundedBuffer();

        //新建写线程
        for(int i = 0 ;i < 6;i++){
            int finalI = i;
            Thread put = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前是写线程，编号"+ finalI);
                    bb.put("当前是写线程，编号"+ finalI);
                }
            });
            put.start();
        }
        System.out.println("开始睡眠");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("睡眠结束");
        System.out.println(bb.items);
        System.out.println(bb.count);
        
        //新建读线程
        for(int i = 0 ;i < 6;i++){
            int finalI = i;
            Thread take = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String s = (String)bb.take();
                        System.out.println("当前是读线程，编号"+ finalI+"，读取结果："+s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            take.start();
        }

    }
}
