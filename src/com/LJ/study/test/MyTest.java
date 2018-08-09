package com.LJ.study.test;

public class MyTest {
    Person person = new Person("MyTest");
    static {
        System.out.println("MyTest static"); // 1
    }

    public MyTest() {
        System.out.println("MyTest constructor"); // 6
    }

    public static void main(String[] args) {
        System.out.println("mytest main"); //2
        new MyClass();
    }
}

class Person {
    static {
        System.out.println("person static"); // 4
    }

    public Person(String str) {
        System.out.println("Person " + str); // 5 mytest
        // 7 myclass
    }
}

class MyClass extends MyTest {
    Person person = new Person("myclass");
    static {
        System.out.println("myclass static"); // 3
    }

    public MyClass() {
        System.out.println("myclass constructor"); // 8
    }
}