package com.LJ.study.mode.proxy;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int num1, int num2) {
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
