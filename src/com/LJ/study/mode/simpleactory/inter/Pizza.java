package com.LJ.study.mode.simpleactory.inter;

import com.LJ.study.mode.simpleactory.material.inter.Cheese;
import com.LJ.study.mode.simpleactory.material.inter.Dough;
import com.LJ.study.mode.simpleactory.material.inter.Sauce;
import com.LJ.study.mode.simpleactory.material.inter.Veggies;

import java.util.Arrays;

/**
 * 披萨抽象类，使用原料接口
 * 简化代码，部分原料实现与工厂实现并未写出来，他们与现有定义完全一样，区别是纽约换成了北京
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    protected Cheese cheese;

    protected abstract void prepare();

    void bake(){
        System.out.println("Bake 20");
    }

    void cut(){
        System.out.println("cut");
    }

    void box(){
        System.out.println("box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                '}';
    }
}
