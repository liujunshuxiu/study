package study.mode.gener;

import java.util.List;

public class GenerTest {
    /**交换list中第i和j位*/
    public static void smap(List<?> list, int i, int j){
        //list.set(i,list.set(j,list.get(j))); //报错，List<?>无法放入除null之外的任何值
        swapHelper(list,i,j);
    }

//    private static <E> void swapHelper(List<E> list, int i, int j) {
//        list.set(i,list.set(j,list.get(i)));
//    }

    //泛型方法一定要定义返回值吗？
//    private static void swapHelper(List<E> list, int i, int j) {
//        list.set(i,list.set(j,list.get(i)));
//    }


    private static  void swapHelper(List list, int i, int j) {
        list.set(i,list.set(j,list.get(i)));
    }
}
