package study.daily;

import study.util.DaDaTimeUtil;

import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(new Date().getTime()/1000);

        long forceLockTimeOut  = DaDaTimeUtil.endTimeOfDay().getTimeInMillis() - System.currentTimeMillis();
        System.out.println("forceLockTimeOut:"+forceLockTimeOut);
    }
}
