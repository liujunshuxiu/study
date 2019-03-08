package study;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

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
        // 取出明天日期
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DATE, 1);
//        Date nextDate = calendar.getTime();
//        // 取明天是星期几
//        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE",Locale.CHINESE);
//        String week = dateFm.format(nextDate);
//
//        System.out.printf("week:%s",week);
//
//
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
//        list.sort((i1,i2) -> i1.compareTo(i2));
//
//        String str = "";
//        System.out.println("长度:"+str.length());

//        BigDecimal bg = new BigDecimal(-12.5).setScale(0, RoundingMode.UP);
//        System.out.println("bg:"+bg);

//        BigDecimal bignum1 = new BigDecimal("19");
//        BigDecimal bignum2 = new BigDecimal("5");
//        BigDecimal bignum3 = null;
//        //除法
//        bignum3 = bignum1.divide(bignum2,0,BigDecimal.ROUND_DOWN);
//        System.out.println("除  是：" + bignum3);


            int[] nums1 = {1,2,3,0,0,0};
            int[] nums2 = {4,5,6};
            int m = 3,n = 3;
            merge(nums1,m,nums2, n);

            for(int i : nums1){
                System.out.println(i);
            }

    }

    private static void merge(int[] nums1,int m ,int[] nums2,int n){
        int index1 = m - 1, index2 = n - 1 ;
        int indexMerge = m + n - 1;
        while(index1 >= 0 || index2 >= 0){
            if(index1 < 0){
                nums1[indexMerge --] = nums2[index2 --];
            }else if(index2 < 0){
                nums1[indexMerge --] = nums1[index1 --];
            }else if(nums1[index1] > nums2[index2]){
                nums1[indexMerge --] = nums1[index1 --];
            }else {
                nums1[indexMerge --] = nums2[index2 --];
            }
        }
    }

}
