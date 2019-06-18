package study.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * jvm动态类型语言支持
 * invokedynamic字节码指令
 * 有点像lamda的Function
 */
public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }


    private static MethodHandle getPrintMH(Object reveiver) throws Throwable{
        // 接收数组，返回一个List对象
//        MethodType mt = MethodType.methodType(List.class, Object[].class);
        MethodType mt = MethodType.methodType(void.class,String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
    }

    public static void main(String[] args) throws Throwable{
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintMH(obj).invoke("icyfenixghf");
    }

}
