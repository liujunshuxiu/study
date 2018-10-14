package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainTest {



    private static void deal(int a,List<Integer> list){
        a = 1;
        List<Integer>  newLIst = list;


        newLIst.add(0,5);
        newLIst.add(1,6);
        newLIst.add(2,7);
    }

    public static void main(String[] args){
//        int a = 0;
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
//        deal(a,list);
//        System.out.println(a);
//        System.out.println(list);

        int i = 0 , j = 0;
//        i = (i++);
        i++;
        j = j++;
        System.out.println("i:"+i);
        System.out.println("j:"+j);
    }



}
