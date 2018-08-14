package com.LJ.study.mode.example;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
    private  Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(1946,Calendar.JANUARY,1,0,0,0);
        BOOM_START = gmt.getTime();
        gmt.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END = gmt.getTime();
    }

    public boolean isBabyBoomer(){
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) <0;
    }
}
