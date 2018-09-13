package main.java.study.concurrence.atomic.adder;

public class CountMainTest {
    public static void main(String[] args){

            ConTest test = new ConTest();
            test.addOne();
            test.addOne();

            ConTest.addOne();
            ConTest.addOne();
            ConTest.addOne();
            System.out.println("123");
    }
}
