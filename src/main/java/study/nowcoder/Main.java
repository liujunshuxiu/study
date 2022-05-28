package study.nowcoder;


import java.util.*;
import java.util.stream.Collectors;


public class Main {

    //所有牌
    private static Map<Integer,Integer> totalMap = new HashMap<>();
    //J到C与数字的映射
    private static Map<String,Integer> refMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //初始化所有牌
        initTotalMap(totalMap);
        //初始化映射关系
        initRefMap(refMap);

        while (sc.hasNextLine()) {
            String myStr = sc.nextLine();
            String[] myStrs= myStr.split("-");
            //移除当前已有牌
            for(String str : myStrs){
                Integer num = refMap.get(str);
                totalMap.put(num,totalMap.get(num) - 1);
            }

            String outStr = sc.nextLine();
            String[] outStrs= outStr.split("-");
            //移除已出的牌
            for(String str : outStrs){
                totalMap.put(refMap.get(str),totalMap.get(refMap.get(str))- 1);
            }


            Set<Integer> res = new HashSet<>();
            //填充所有剩余的牌
            for(int i = 14; i > 2 ; i--){
                if(totalMap.get(i) > 0){
                    res.add(i);
                }
            }

            System.out.println("res:"+ res);

            int length = 0;
            List<Integer> resList = new LinkedList<>();

            List<Integer> list = new LinkedList<>();
            //从3开始找出所有复合条件的最长顺子,最多到j
            for(int i = 3 ; i < 11 ; i++){
                int size = 0;
                list.clear();

                for(int j = i ; j < 15 ; j++){
                    if(res.contains(j)){
                        size ++;
                        list.add(j);
                    }else {
                        break;
                    }
                }

                if(size < 5){
                    continue;
                }

                if(size >= length){
                    length = size;
                    resList = new ArrayList<>(list);
                }
            }

            if(resList.size() == 0){
                System.out.println("NO-CHAIN");
            }else {


                String result = resList.stream().map(i -> {
                    if(i == 11){
                        return "j";
                    }else if(i == 12){
                        return "Q";
                    }else if(i == 13){
                        return "K";
                    }else if(i == 14){
                        return "A";
                    }else {
                        return String.valueOf(i);
                    }
                }).collect(Collectors.joining(","));
                System.out.println(result);
            }

        }
    }

    //初始化映射关系
    private static void initRefMap(Map<String, Integer> refMap) {
        refMap.put("B",0);//小王
        refMap.put("C",1);//大王

        refMap.put("2",2);
        refMap.put("3",3);
        refMap.put("4",4);
        refMap.put("5",5);
        refMap.put("6",6);
        refMap.put("7",7);
        refMap.put("8",8);
        refMap.put("9",9);
        refMap.put("10",10);

        refMap.put("J",11);
        refMap.put("Q",12);
        refMap.put("K",13);
        refMap.put("A",14);

    }

    //初始化所有牌
    private static void initTotalMap(Map<Integer, Integer> totalMap) {
        for(int i = 2 ;i < 15;i++){
            totalMap.put(i,4);
        }

        //加入小王大王
        totalMap.put(0,2);
        totalMap.put(1,2);
    }
}