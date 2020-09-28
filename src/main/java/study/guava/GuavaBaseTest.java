package study.guava;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

public class GuavaBaseTest {

    @Test
    public void baseTest(){
        //int快速转list
        List<Integer> intList = Ints.asList(1, 3, 5, 7, 9);
        //拼接
        System.out.println(Ints.join(",",1, 3, 5, 7, 9));
        //快速合并
        int[] concat = Ints.concat(new int[]{1, 2}, new int[]{3, 4, 5});
        //最大最小
        System.out.println(Ints.max(concat)+","+Ints.min(concat));
        //是否包含
        System.out.println(Ints.contains(concat,6));
    }
}
