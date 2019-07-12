package study.mode.proxy;

import java.util.List;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int num1, int num2) {
        
        List<String> list1= null;
        for(String a : list1){
            System.out.println(a);
        }
//        if(num1 == 1){
//            throw new NullPointerException("抛异常测试");
//        }

        int ret = num1 + num2;
        System.out.println("in calculatorImpl, res: " + ret);
        return ret;
    }

    @Override
    public int minus(int num1, int num2) {
        int ret = num1 - num2;
        System.out.println("in calculatorImpl, res: " + ret);
        return ret;
    }
}
