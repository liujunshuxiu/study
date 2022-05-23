package study.daily;

import org.junit.Before;
import org.junit.Test;
import study.dada.DailyCourse1;

import java.util.*;

public class StackTest {

    public static final String appName;

    // 定义一个队列
    Queue<String> queue;


    static {
        appName = "sdf";
    }

    @Before
    public void before() {
    // 实例化队列变量
        queue = new LinkedList<String>();

        // add方法向队列中添加元素,返回布尔值，add方法添加失败时会抛异常,不推荐使用
        // queue.add("1");
        // queue.add("2");
        // queue.add("3");
        // queue.add("4");
        // queue.add("5");

        // offer方法向队列中添加元素，返回布尔值
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
    }

    @Test
    public void test1() {
// 弹出元素
        String pollEle = queue.poll(); // 先进先出,弹出了aha sh
        System.out.println(pollEle); // a
        System.out.println(queue); // [b, c, d, e]
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
