package com.LJ.study.test;

public class SortTest {


    public static void main(String[] args){

        int i = 0;
        int[] a = {5,4,9,8,7,6,0,1,3,2};
//        //选择排序
//        selectSort(a);
//
//        //冒泡
//        BubbleSort(a);

        //快速排序
        quickSort(a);
        for(i = 0;i < a.length;i++){
            System.out.print(a[i]+"");
        }

    }

    //======================================================================

    /**
     * 选择排序法
     * 对给定的一组数据，经过第一轮比较后得到最小的记录，然后将该记录与第一个记录的位置进行交换，接着对不包括第一个记录以外的其它记录进行第二轮比较，重复此操作
     * @param a
     */
    public static void selectSort(int[] a){
        //当前处理位
        int i;
        //循环时起始位
        int j;
        //当前循环时最小数
        int temp = 0;
        //最小下标位
        int flag = 0;
        int n = a.length;
        for(i = 0; i < n ;i ++){
            temp = a[i];
            flag = i;
            for(j = i + 1;j<n;j++){
                if(a[j] < temp){
                    temp = a[j];
                    flag = j;
                }
            }
            if(flag != i){
                a[flag] = a[i];    //将当前位换给最小位
                a[i] = temp;        //将此次循环最小位赋给当前位
            }
        }
    }

    //======================================================================

    /**
     * 冒泡排序
     * 相邻两个数互相比较
     * @param array
     */
    public static void BubbleSort(int[] array){
        int i,j;
        int len = array.length;
        int tmp;
        for(i = 0;i<len -1;++i){
            for(j = len -1;j > i ; --j){
                if(array[j] < array[j -1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }

   //======================================================================

    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int array[]){
        sort(array,0,array.length -1);
    }

    public static void sort(int[] array,int low,int high){
        int i ;
        int j ;
        int index;
        if(low >= high){
            return;
        }
        i = low;
        j = high;

        index = array[i];
        while (i<j){
            while (i<j&&array[j]>=index){
                j--;
            }
            if(i<j){
                array[i++] = array[j];
            }
            while (i<j&&array[i]<index){
                i++;
            }
            if(i<j){
                array[j--]=array[i];
            }
        }

        array[i] = index;
        sort(array,low,i-1);
        sort(array,i+1,high);
    }
}
