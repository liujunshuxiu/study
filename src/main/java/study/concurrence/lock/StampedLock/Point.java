package study.concurrence.lock.StampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * 在读的过程中发生了写操作，应该重新读而不是直接阻塞写线程
 */
public class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     * 改变当前坐标。
     * 先获取写锁，然后对point坐标进行修改，最后释放锁。
     * 该锁是排它锁，这保证了其他线程调用move函数时候会被阻塞，直到当前线程显示释放了该锁。
     */
    void move(double deltaX, double deltaY) { // an exclusively locked method
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
            System.out.println(String.format("move移动到位置，x:%f,y:%f,名称:%s",x,y,Thread.currentThread().getName()));
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 计算当前坐标到原点的距离
     *
     * @return
     */
    double distanceFromOrigin() { // A read-only method
        //1.尝试获取乐观读锁，返回stamp
        long stamp = sl.tryOptimisticRead();
        //2.拷贝参数到本地方法栈中
        double currentX = x, currentY = y;
        //3.验证stamp是否有效
        boolean flag = !sl.validate(stamp);
        System.out.println(String.format("stamp是否有效:%b，名称:%s",flag,Thread.currentThread().getName()));
        if (flag) {
            //4.如果stamp无效，说明得到stamp后，又有其他线程获得了写锁
            //5.获取读锁
            stamp = sl.readLock();
            try {
                //6.其他线程修改了x,y的值，为了数据的一致性，需要再次再次拷贝参数到本地方法栈中
                currentX = x;
                currentY = y;
            } finally {
                //7.释放读锁
                sl.unlockRead(stamp);
            }
        }
        System.out.println(String.format("当前位置，x:%f,y:%f,名称:%s",currentX,currentY,Thread.currentThread().getName()));
        //8.使用参数的拷贝来计算当前坐标到原点的距离。无论步骤3中stamp有没有验证成功，参数的拷贝都是当前坐标的值
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 如果当前坐标为原点则移动到指定的位置
     */
    void moveIfAtOrigin(double newX, double newY) { // upgrade
        // 获取读锁，保证其他线程不能获取到写锁
        long stamp = sl.readLock();
        try {
            //如果当前坐标为原点
            while (x == 0.0 && y == 0.0) {
                //尝试升级成写锁
                long ws = sl.tryConvertToWriteLock(stamp);
                //如果升级成功，更新坐标值
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {//如果升级成功
                    sl.unlockRead(stamp);//先释放读锁
                    stamp = sl.writeLock();//再获取写锁
                    //循环while中的操作，直到成功更新坐标值
                }
            }
        } finally {
            //最后释放写锁
            sl.unlock(stamp);
        }
    }


    public static void main(String[] args){
        final Point point = new Point();

        for(int i = 0 ;i < 6;i++){
            Thread move = new Thread(new Runnable() {

                @Override
                public void run() {
                    double xp = (double)(Math.random() * 10);
                    double yp = (double)(Math.random() * 10);
                    point.move(xp,yp);
//                    System.out.println("坐标被移动到了，x:"+xp+",y:"+yp);
                    System.out.println(String.format("坐标被移动到了，x:%f,y:%f,名称:%s",xp,yp,Thread.currentThread().getName()));
                }
            });
            move.start();
        }


        for(int i = 0 ;i < 5;i++){
            Thread dis = new Thread(new Runnable() {
                @Override
                public void run() {
                    double distance = point.distanceFromOrigin();
                    System.out.println("当前是计算距离线程，距离:"+distance+",名称:"+Thread.currentThread().getName());
                }
            });
            dis.start();
        }





    }

}
