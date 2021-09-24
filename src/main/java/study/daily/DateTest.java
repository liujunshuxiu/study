package study.daily;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class DateTest {

    static void time(int field ,int amount) {
        //输出5月32号   五月三十二号离四月五号有57天
        Calendar cal = Calendar.getInstance();
//        add它移动的是日期的偏移量。
        cal.add(field, amount);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(cal.getTime())); //格式化日期
    }
    public static void main(String[] args) {

//        time(Calendar.DAY_OF_MONTH,1);

       boolean flag =  (6==EStudentStatus.OPENCARD.getCode() ||
                (6 == EStudentStatus.SIGNED.getCode() && 0 == 1) ||
                6 >= EStudentStatus.ENDCLASS_MORE_THAN_60_DAYS.getCode()
                        && 6 < EStudentStatus.ONCE_AGAIN_SIGN.getCode());

        System.out.println("flag = " + flag);
    }
}
