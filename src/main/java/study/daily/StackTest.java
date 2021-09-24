package study.daily;

import study.dada.DailyCourse1;

import java.util.*;

public class StackTest {

    public static final String appName;

    static {
        appName = "sdf";
    }

    public static void main(String[] args) {
//        Stack<Object> stack = null;
//        if (stack == null || stack.peek() == null) {
//            return;
//        }
//
//        appName = "ssff";

        DailyCourse1.Parent p1 = new DailyCourse1.Parent("f1","c1","f");
        DailyCourse1.Parent p2 = new DailyCourse1.Parent("f2","c1","f");
        DailyCourse1.Parent p3 = new DailyCourse1.Parent("m1","c2","m");
        DailyCourse1.Parent p4 = new DailyCourse1.Parent("m2","c3","m");
        DailyCourse1.Parent p5 = new DailyCourse1.Parent("f3","c3","f");
        DailyCourse1.Parent p6 = new DailyCourse1.Parent("f4","c4","f");
        DailyCourse1.Parent p7 = new DailyCourse1.Parent("m3","c5","m");
        DailyCourse1.Parent p8 = new DailyCourse1.Parent("m4","c6","m");
        DailyCourse1.Parent p9 = new DailyCourse1.Parent("m5","c7","m");
        DailyCourse1.Parent p10 = new DailyCourse1.Parent("f6","c8","f");

        List<DailyCourse1.Parent> parents = new ArrayList<>();
        parents.add(p1);
        parents.add(p2);
        parents.add(p3);
        parents.add(p4);
        parents.add(p5);
        parents.add(p6);
        parents.add(p7);
        parents.add(p8);
        parents.add(p9);
        parents.add(p10);

        parents.forEach(parent -> {
            if (parent.getParentName().equals("f1")) {
                System.out.println("plane1:");
                return;
            }
            System.out.println("other:");

        });


    }
}
