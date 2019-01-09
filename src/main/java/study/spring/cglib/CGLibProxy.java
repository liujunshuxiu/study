package study.spring.cglib;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import study.concurrence.cas.UnSafeDemo;
import study.spring.jdk.ExInterface;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CGLibProxy implements MethodInterceptor {


    public Object createProxy(Class target){
        // 使用CGLIB生成代理:
        // 1.声明增强类实例,用于生产代理类
        Enhancer enhancer = new Enhancer();
        // 2.设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        enhancer.setSuperclass(target);
        // 3.//设置回调函数，即一个方法拦截
        enhancer.setCallback(this);
        // 4.创建代理:
        return  enhancer.create();
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate  = simpleDateFormat.format(new Date());
        System.out.println("日期【"+currentDate + "】进入代理");
        //如果不需要增强直接执行原方法
        return methodProxy.invokeSuper(proxy, args);
    }
    
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        CGLibProxy cgLibProxy = new CGLibProxy();
        //cglib代理类
//        CglibDemo proxy = (CglibDemo)cgLibProxy.createProxy(CglibDemo.ljclass);
//        UnSafeDemo proxy = (UnSafeDemo)cgLibProxy.createProxy(UnSafeDemo.ljclass);
//        proxy.execute();

//        //cglib代理接口(有问题)
//        ExInterface exProxy = (ExInterface)cgLibProxy.createProxy(ExInterface.ljclass);
//        exProxy.execute();

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:/Users/admin-lj/Desktop/code");
        //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer eh = new Enhancer();
        //设置目标类
        eh.setSuperclass(CglibDemo.class);
        // 设置拦截对象
        eh.setCallback(new CGLibProxy());
        /* 生成代理类并返回一个实例 */
        CglibDemo proxy = (CglibDemo) eh.create();
        proxy.execute();
    }
}
