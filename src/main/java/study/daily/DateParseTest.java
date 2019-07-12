package study.daily;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParseTest {
    public static void main(String[] args){
        String date = "2019/5/21";

        SimpleDateFormat formatter = new SimpleDateFormat( "y/M/d");

        Date result = null;
        try {
            result = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
