package study.sundry.staticTest;

import java.util.*;

public class StaticDemo {

    public static  int i = 0;
    public static final Map<String,String> map = new HashMap<String,String>(){{put("初始值","static");}};
    public static final List<String> list = Arrays.asList("str1", "str2");

    static {
        System.out.println("static代码块被执行了："+(++i)+"次");
    }
    
    public static void main(String[] args){
        StaticDemo demo = new StaticDemo();
        StaticDemo demo2 = new StaticDemo();
        StaticDemo demo3 = new StaticDemo();
        System.out.println("初始完毕");
    }

}
