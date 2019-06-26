package study.concurrence.vector;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class VectorTest {

        private static Vector<Integer> vector = new Vector<>();
//    private static ConcurrentHashMap<Integer, Integer> comHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        try {
            while (true) {

                for (int i = 0; i < 10; i++) {
                    vector.add(i);
                }


                Thread removeThread = new Thread(() -> {
                    for (int i = 0; i < vector.size(); i++) {
//                        出错的原因在这儿，size()方法是同步的，remove方法也是同步的，但是这两部之间并不同步，数据有可能被其它线程修改，所以需要增加synchronized(对象)
                        vector.remove(i);
                    }
                });

                Thread printThread = new Thread(() -> {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(Thread.currentThread().getName() + vector.get(i));
                    }
                });
//
//
//                for (int i = 0; i < 10; i++) {
//                    comHashMap.put(i, i);
//                }


//                Thread removeThread = new Thread(() -> {
//                    for (int i = 0; i < comHashMap.size(); i++) {
////                        vector.remove(i);
//                        comHashMap.remove(i);
//                    }
//                });
//
//                Thread printThread = new Thread(() -> {
//                    for (int i = 0; i < comHashMap.size(); i++) {
////                        System.out.println(Thread.currentThread().getName() + vector.get(i));
//                        System.out.println(Thread.currentThread().getName() + comHashMap.get(i));
//                    }
//                });


                /**
                 * 正确写法如下
                 */
//                Thread removeThread = new Thread(() -> {
//                    synchronized (comHashMap){
//                        for (int i = 0; i < comHashMap.size(); i++) {
////                        vector.remove(i);
//                            comHashMap.remove(i);
//                        }
//                    }
//
//                });
//
//                Thread printThread = new Thread(() -> {
//                    synchronized (comHashMap){
//                        for (int i = 0; i < comHashMap.size(); i++) {
////                        System.out.println(Thread.currentThread().getName() + vector.get(i));
//                            System.out.println(Thread.currentThread().getName() +"_i="+i+"comHashMap.get(i) ="+ comHashMap.get(i));
////                            System.out.printf("当前线程名称:%s，i = %s，comHashMap.get(i) = %s",Thread.currentThread().getName(),i,comHashMap.get(i));
//                        }
//                    }
//                });

                removeThread.start();
                printThread.start();

                while (Thread.activeCount() > 20) {

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出错了");
        }

    }

}
