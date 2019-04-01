package study.arithmetic.practice;

import java.util.*;

/**
 * 蚂蚁金服算法题
 * 九宫格电话键盘上每个数字对于多个字母，
 * 给定任意一个数字（不包含1），打印出所有字母组合。
 */
public class Tel {

    private static Map<Integer,String[]> telMap = new HashMap<>();

    static {
        telMap.put(2, new String[]{"A", "B", "C"});
        telMap.put(3, new String[]{"D", "E", "F"});
        telMap.put(4, new String[]{"G", "H", "I"});
        telMap.put(5, new String[]{"J", "K", "L"});
        telMap.put(6, new String[]{"M", "N", "O"});
        telMap.put(7, new String[]{"P", "Q", "R","S"});
        telMap.put(8, new String[]{"T", "U", "V"});
        telMap.put(9, new String[]{"W", "X", "Y", "Z"});
    }

    private static List<String[]> combAll(List<Integer> nums){
        List<String[]>  results = null;
        for(Integer num : nums){
            results = assbALl(results,telMap.get(num)) ;
        }
        return results;
    }

    private static List<String[]> assbALl(List<String[]> results, String[] strings) {
        if(results == null){
            List<String[]> list = new ArrayList<>();
            for(String content : strings){
                list.add(new String[]{content});
            }
            return list;
        }else {
            List<String[]> newList = new ArrayList<String[]>();
            for(String string : strings){
                for(String[] ress : results) {
                    String[] newCon = new String[ress.length + 1];
                    System.arraycopy(ress, 0, newCon, 0, ress.length);
                    newCon[ress.length] = string;
                    newList.add(newCon);
                }
            }
            return newList;
        }

    }


    private static List<Integer> getNums(int num) {
        int length = 1 ;
        while (num / length > 0){
            length = 10 * length;
        }
        int size = length ;
        List<Integer> res = new LinkedList<>();

        while ((size = (size / 10)) > 0 ){
            int ress = num / size;
            res.add(ress) ;
            num = num - ress * size;
        }
        return res;
    }

    public static void main(String[] args){

        List<Integer> nums = getNums(34543543);
        List<String[]> all = combAll(nums);

        System.out.println("all大小:"+all.size());
        for (String[] result :  all){
            System.out.print("result:");
            for(String i : result){
                System.out.print(i);
            }
            System.out.println();
        }
    }



}
