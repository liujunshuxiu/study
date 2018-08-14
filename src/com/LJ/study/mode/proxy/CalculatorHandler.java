package com.LJ.study.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * 有疑问，这只是个代理工具而已，实现类是单独实例化？还是由这个工具决定该实例化哪个？
 * 动态生成的类，是用来干什么的？减小了哪一部分的工作？最后它还是会调回这个CalculatorHandler去执行invoke函数，它的意义是啥？
 */
public class CalculatorHandler implements InvocationHandler {

    private String inputFields;//各种传入条件
    private Object obj; //被代理类

    public CalculatorHandler(String inputFields){

        //在这里根据各种传入条件使用不同的实现类
        Calculator calculatorImpl = new CalculatorImpl();
        this.obj = calculatorImpl;
    }

    public Object getObj() {
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("in calculatorhandler, before invocation");

        Object ret = method.invoke(obj, args);

        System.out.println("in calculationhandler, after invocation");
        return ret;
    }


    public static void main(String[] args){

        CalculatorHandler calculatorHandler = new CalculatorHandler("条件1");
        Calculator calculator = (Calculator)Proxy.newProxyInstance(calculatorHandler.getObj().getClass().getClassLoader(),calculatorHandler.getObj().getClass().getInterfaces(),calculatorHandler);
        System.out.println(calculator.add(1,2));
        System.out.println(calculator.minus(1, 2));
    }
}
