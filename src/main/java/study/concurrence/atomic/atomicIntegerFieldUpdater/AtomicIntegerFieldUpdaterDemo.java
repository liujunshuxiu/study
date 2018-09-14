package study.concurrence.atomic.atomicIntegerFieldUpdater;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 更新原子属性
 */
public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate{
        int id;
        volatile int score;
    }

    public static class Game{
        int id;
        volatile String name;

        public Game(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    
    public static void main(String[] args) throws InterruptedException {

        final AtomicIntegerFieldUpdater<Candidate> atIntegerUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

        AtomicReferenceFieldUpdater<Game,String> atRefUpdate =
                AtomicReferenceFieldUpdater.newUpdater(Game.class,String.class,"name");

        //用于验证分数是否正确
        final AtomicInteger allScore=new AtomicInteger(0);


        final Candidate stu=new Candidate();

        Thread[] t=new Thread[10000];
        //开启10000个线程
        for(int i = 0 ; i < 10000 ; i++) {
            t[i]=new Thread() {
                public void run() {
                    if(Math.random()>0.4){
                        atIntegerUpdater.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }

        for(int i = 0 ; i < 10000 ; i++) {  t[i].join();}
        System.out.println("最终分数score="+stu.score);
        System.out.println("校验分数allScore="+allScore);

        //AtomicReferenceFieldUpdater 简单的使用
        Game game = new Game(2,"zh");
        atRefUpdate.compareAndSet(game,game.name,"LiuJun-HAHAHA");
        System.out.println(game.toString());
    }
}
