package com.LJ.study.concurrence.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeDemo {
    
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        System.out.println(unsafe);
        //通过allocateInstance直接创建对象
        User user = (User)unsafe.allocateInstance(User.class);

        Class userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field age = userClass.getDeclaredField("age");
        Field id = userClass.getDeclaredField("id");

        unsafe.putInt(user,unsafe.objectFieldOffset(age),18);
        unsafe.putObject(user,unsafe.objectFieldOffset(name),"LiuJunTianCai");
//        unsafe.putObject(user,unsafe.objectFieldOffset(id),"static问题?");


        Object staticBase = unsafe.staticFieldBase(id);
        System.out.println("staticBase:"+staticBase);

        //获取静态变量id的偏移量staticOffset
        long staticOffset = unsafe.staticFieldOffset(userClass.getDeclaredField("id"));
        //获取静态变量的值
        System.out.println("设置前的ID:"+unsafe.getObject(staticBase,staticOffset));
        //设置值
        unsafe.putObject(staticBase,staticOffset,"SSSLLLLJJJJ");
        //获取静态变量的值
        System.out.println("设置后的ID:"+unsafe.getObject(staticBase,staticOffset));
        //输出USER
        System.out.println("输出USER:"+user.toString());

        long data = 1000;
        byte size = 1;//单位字节

        //调用allocateMemory分配内存,并获取内存地址memoryAddress
        long memoryAddress = unsafe.allocateMemory(size);

        unsafe.putAddress(memoryAddress,data);

        //获取指定内存地址的数据
        long addrData=unsafe.getAddress(memoryAddress);
        System.out.println("addrData:"+addrData);

    }
}
