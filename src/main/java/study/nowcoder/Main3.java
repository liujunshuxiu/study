package study.nowcoder;

import java.util.*;

//时间不够了
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //整理好所有数据
        List<int[]> arrLists = new ArrayList<>();

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] splits = str.split(" ");
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(splits[0]);
            arr[1] = Integer.parseInt(splits[1]);
            System.out.println(arr[0]+" "+arr[1]);
            arrLists.add(arr);
        }


        //key -下标 ，value - 第一次计算的结果
        Map<Integer,List<int[]>> map = new HashMap<>();

        for(int i = 0 ; i < arrLists.size();i++){
            int[] base = arrLists.get(i);
            List<int[]> lists = new ArrayList<>();
            map.put(i,lists);

            for(int j = i ; j < arrLists.size();j++){
                int[] arr = arrLists.get(j);

                //超过空间不处理
                if(base[1] < arr[1] && base[1] < arr[0]){
                    continue;
                }
                //超过空间不处理
                if(base[1] > arr[1] && base[1] > arr[0]){
                    continue;
                }

                //合并区间
                if(base[1] < arr[1] &&  base[1] > arr[0]){
                    int[] arrn = new int[2];
                    arr[0] = base[1];
                    arr[1] = arr[0];
                    lists.add(arrn);
                }

                if(base[1] > arr[1] &&  base[1] < arr[0]){
                    int[] arrn = new int[2];
                    arr[0] =  arr[0];
                    arr[1] = base[1];
                    lists.add(arrn);
                }
            }

            Map<Integer,int[]> map2 = new HashMap<>();
            for(Map.Entry entry : map.entrySet()){
                //合并每一行的交集
                //保存结果
//                map2.put(entry.key,);
            }

            //对map2在计算



        }
    }
}