package study.base;

public class ChildTest extends ParentTest{

    static{
        System.err.println("子类静态代码块");
    }
    private static String var1 = initStaticParent();
    {
        System.err.println("子类构造代码块");
    }
    private  String var2 = initStringParent();

    public ChildTest(){
        System.err.println("子类构造方法");
    }

    private String initStringParent(){
        System.err.println("子类普通方法给变量赋值");
        return "initStringParent";
    }

    private static String initStaticParent(){
        System.err.println("子类静态方法给变量赋值");
        return "initStaticParent";
    }

}