package study.threadlocal;

public class ThreadLocalDemo2 {
   public static void main(String[] args) {
       ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"java 金融");
     System.out.println("获取初始值："+threadLocal.get());
     threadLocal.set("关注：【java 金融】");
     System.out.println("获取修改后的值："+threadLocal.get());
//     threadLocal.remove();
       System.gc();
     System.out.println("获取修改后的值："+threadLocal.get());
   }
}
