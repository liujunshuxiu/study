package study.nowcoder;


import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0 ; i< n;i++){
                arr[i] = sc.nextInt();
            }

            //阈值
            int value = sc.nextInt();

            Arrays.sort(arr);



            //最终总数
            int num = 0;
            //低于能力值的最终人
            int index = n;

            for(int i =0 ; i< n;i++){
                //单人超过的直接计数，并记录起始下标
               if (arr[i] >= value){
                   num ++;
                   index = Math.min(i,index);
               }
            }

            //特殊情况处理，全大于能力值
            if(index == 0){
                System.out.println(num);
                return;
            }

            //双指针,首尾最多能匹配出的人为最终结果
            int startIndex = 0;
            int endIndex = index - 1;


            while (startIndex < endIndex){
                int a = arr[startIndex];
                int b = arr[endIndex];
                if(arr[startIndex] + arr[endIndex] >= value){
                    num++;
                    startIndex++;
                    endIndex--;
                }else {
                    startIndex++;
                }
            }


            System.out.println(num);
        }
     }
}