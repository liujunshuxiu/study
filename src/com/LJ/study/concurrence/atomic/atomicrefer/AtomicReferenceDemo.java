package com.LJ.study.concurrence.atomic.atomicrefer;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    // 普通引用
    private static Person person;

    private static AtomicReference<Person> aRperson;

    static class Task1 implements Runnable {
//        public void run() {
//            person.setAge(person.getAge() + 1);
//            person.setName("Tom1");
//
//            System.out.println("Thread1 Values "
//                    + person.toString());
//        }
        public void run(){
            aRperson.getAndSet(new Person("Tom1",aRperson.get().getAge()+1));
            System.out.println("Thread1 Atomic References "
                    + aRperson.get().toString());
        }
    }

    static class Task2 implements Runnable {
//        public void run() {
//            person.setAge(person.getAge() + 2);
//            person.setName("Tom2");
//
//            System.out.println("Thread2 Values "
//                    + person.toString());
//        }
        public void run(){
            aRperson.getAndSet(new Person("Tom2", aRperson.get().getAge() + 2));

            System.out.println("Thread2 Atomic References "
                    + aRperson.get().toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        person = new Person("Tom", 18);
        //包装
        aRperson = new AtomicReference<Person>(person);

        System.out.println("Person is " + person.toString());

        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Now Person is " + person.toString());
    }
}
