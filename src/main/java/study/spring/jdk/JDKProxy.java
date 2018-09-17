package study.spring.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDKProxy implements InvocationHandler {

    /**
     * 要被代理的类
     */
    private ExInterface exInterface;


    public JDKProxy(ExInterface exInterface){
        this.exInterface = exInterface;
    }

    /**
     * 创建代理类
     * @return
     */
    public Object createProxy(){
        return Proxy.newProxyInstance(exInterface.getClass().getClassLoader(),exInterface.getClass().getInterfaces(),this);
    }

    /**
     * 调用被代理类(目标对象)的任意方法都会触发invoke方法
     * @param proxy 代理类
     * @param method 被代理的方法
     * @param args 被代理类的方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate  = simpleDateFormat.format(new Date());
        System.out.println("日期【"+currentDate + "】进入代理");
        //如果不需要增强直接执行原方法
        return method.invoke(exInterface,args);
    }


    public static void main(String[] args) throws IOException {
        ExImpl ex = new ExImpl();
        //创建JDK代理
//        JDKProxy jdkProxy = new JDKProxy(ex);

        //创建代理对象
        ExInterface proxy = (ExInterface) new JDKProxy(ex).createProxy();

        //执行代理对象方法
        proxy.execute();

        // 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{ex.getClass()});

        FileOutputStream os = new FileOutputStream("C:/Users/admin-lj/Desktop/Proxy0.class");
        os.write(bytes);
        os.close();

    }

}
