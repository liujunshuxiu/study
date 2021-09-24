package study.daily;

public class StringTest {
    public static void main(String[] args){
//        String str = "2019-07-18 19:04";
//        String str = "";
//        System.out.println(str.length());
//
//        System.out.println(String.format("该项目已存在相同人员，projectId为：%s身份证号为：%s","xcgd","gdfgd"));

//        String str = "";
//        System.out.println(org.apache.commons.lang3.StringUtils.isBlank(str));
        
//        System.out.println(7 % 60);
        System.out.println(getMinOfSecond(509));
    }

    private static String getMinOfSecond(Integer second) {
        if (second == null || second == 0) {
            return "--";
        }
        int v = second % 60;
        return second / 60 + ":" + (v >= 10 ? v : ("0" + v));
    }
}
