package study.loader;

/**
 * 为了多次载入执行类而加入的加载器
 * 只有外部显示调用的时候才会使用到loadByte方法
 * 虚拟机调用时，仍然按照原有的双亲委派规则使用loadclass方法加载
 */
public class HotSwapClassLoader extends ClassLoader{

    /**
     * 扩大类加载器查找范围，使其能查找到当前目录
     */
    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    /**
     * 公开父类defineClass方法，可以把提交执行的java类byte[]数字转变为clss对象
     * @param classByte
     * @return
     */
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
