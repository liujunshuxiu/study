package study.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorHandlerOld implements InvocationHandler {

    private Object obj; //被代理类

    public CalculatorHandlerOld(Object obj){
        this.obj = obj;
    }

    public CalculatorHandlerOld(){
    }

    private Object proxyBind(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("in calculatorhandler, before invocation");

        Object ret = method.invoke(obj, args);

        System.out.println("in calculationhandler, after invocation");
        return ret;
    }


    public static void main(String[] args){
//        Calculator calculatorImpl = new CalculatorImpl();
//        CalculatorHandlerOld calculatorHandler = new CalculatorHandlerOld(calculatorImpl);
//        Calculator calculator = (Calculator)Proxy.newProxyInstance(calculatorImpl.getClass().getClassLoader(),calculatorImpl.getClass().getInterfaces(),calculatorHandler);

        Calculator calculator = (Calculator)new CalculatorHandlerOld().proxyBind(new CalculatorImpl());
        System.out.println(calculator.add(1,2));
        System.out.println(calculator.minus(1, 2));
    }
}
