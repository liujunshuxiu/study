package study.daily;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 姜峰
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 17611686899
 * @created 2020/3/25 上午9:53
 * @changeRecord
 */

public enum EStudentStatus {

// 原学员状态
//    /**
//     *      学员状态 1: 开卡未签 2: 签约未上 3: 在读学员 4: 停课学员 5: 沉睡学员 6: 结课<60天 7: 退费<60天 8: 结课>=60天 9: 退费>=60天
//     */

    /**
     * status 学员状态 1:开卡未签 2:签约未上 3:在读学员 4:停课学员 5:沉睡学员 6:结课学员 7:退费学员 8:结课可签约(结课>=60天) 9:退费可签(退费>=60天) 10:结退签约未上
     */

    UNSIGN(0, ""),
    OPENCARD(1,"开卡未签"),
    SIGNED(2,"签约未上"),
    STUDYING(3,"在读学员"),
    STOPCLASS(4,"停课学员"),
    SLEEP(5,"沉睡学员"),
    ENDCLASS(6,"结课学员"),
    REFUND(7,"退费学员"),
    ENDCLASS_MORE_THAN_60_DAYS(8, "结课可签"),
    REFUND_MORE_THAN_60_DAYS(9, "退费可签"),
    ONCE_AGAIN_SIGN(10, "结退签约未上");

    private int code;

    private String name;

    EStudentStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getCodeName(int code) {

        for (EStudentStatus gradeCode : EStudentStatus.values()) {
            if (gradeCode.getCode() == code) {
                return gradeCode.getName();
            }
        }
        return null;
    }

    public static List<Integer> keys() {
        List<Integer> list = Lists.newArrayList();
        for (EStudentStatus msg : EStudentStatus.values()) {
            list.add(msg.code);
        }
        return list;
    }

    public static EStudentStatus parseByMessage(String message) {
        for (EStudentStatus gender : EStudentStatus.values()) {
            if (gender.name.equals(message)) {
                return gender;
            }
        }
        return null;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
