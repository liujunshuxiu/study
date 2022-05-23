package study.dada;

import study.concurrence.product.correct.Test;

import java.util.*;
import java.util.stream.Collectors;

public class DailyCourse1 {

    public static class Parent {
        private String parentName; //家长名字
        private String childName; //孩子名字
        private String fatherOrMother; //家长是父亲还是母亲

        private Parent chlid;

        public Parent(String parentName, String childName, String fatherOrMother) {
            this.parentName = parentName;
            this.childName = childName;
            this.fatherOrMother = fatherOrMother;
        }

        public Parent() {
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        public String getFatherOrMother() {
            return fatherOrMother;
        }

        public void setFatherOrMother(String fatherOrMother) {
            this.fatherOrMother = fatherOrMother;
        }
    }

    private static class Course1Counter {
        private int single = 0;

        private Map<String,Integer> students = new HashMap<>( (int) Math.ceil(50 / 0.75f));

        public int getSingle() {
            return single;
        }

        public void setSingle(int single) {
            this.single = single;
        }

        public Map<String, Integer> getStudents() {
            return students;
        }

        public void setStudents(Map<String, Integer> students) {
            this.students = students;
        }
    }

    public static void main(String[] args) {
        Parent p1 = new Parent("f1","c1","f");
        Parent p2 = new Parent("f2","c1","f");
        Parent p3 = new Parent("m1","c2","m");
        Parent p4 = new Parent("m2","c3","m");
        Parent p5 = new Parent("f3","c3","f");
        Parent p6 = new Parent("f4","c4","f");
        Parent p7 = new Parent("m3","c5","m");
        Parent p8 = new Parent("m4","c6","m");
        Parent p9 = new Parent("m5","c7","m");
        Parent p10 = new Parent("f6","c8","f");

        List<Parent> parents = new ArrayList<>();
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

        //方案一 时间空间复杂度未知-.-，不知道这几个函数lambda底层是咋实现的。
        Map<String, List<Parent>> collect = parents.stream().collect(Collectors.groupingBy(Parent::getChildName));
        long count = collect.entrySet().stream().filter(entry -> entry.getValue().size() == 1).count();

        System.out.println("plane1:"+count);

        //方案二 空间n，时间复杂度n
        Set<String> child = new HashSet();
        parents.forEach(parent -> {
            if(!child.contains(parent.getChildName())){
                child.add(parent.getChildName());
            }else {
                child.remove(parent.getChildName());//同一个学生最多出现2次，可remove
            }
        });
        System.out.println("plane2:"+child.size());

        //方案三 空间50 / 0.75f,时间复杂度 n + 50
        Course1Counter counter = new Course1Counter();
        parents.forEach(parent -> {
            if(counter.getStudents().get(parent.getChildName()) == null){
                counter.getStudents().put(parent.getChildName(),1);
            }else{
                counter.getStudents().put(parent.getChildName(),2);
            }
        });
        System.out.println("plane3:"+counter.getStudents().entrySet().stream().filter(entry -> entry.getValue() == 1).count());
    }



}
