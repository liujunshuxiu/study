package study.base;

public class ParentTest {

    private static String var1 = initStaticParent();
    private  String var2 = initStringParent();

    static{
        System.err.println("父类静态代码块");
    }
    {
        System.err.println("父类构造代码块");
    }

    public  ParentTest(){
        System.err.println("父类构造方法");
    }

    private String initStringParent(){
        System.err.println("父类普通方法给变量赋值");
        return "initStringParent";
    }

    private static String initStaticParent(){
        System.err.println("父类静态方法给变量赋值");
        return "initStringParent";
    }

}