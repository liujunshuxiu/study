package study.lambda;

import org.testng.collections.Lists;

import java.util.List;

public class ReduceTest {

    public static void main(String[] args){
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
    }
}
