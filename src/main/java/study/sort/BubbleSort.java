package study.sort;

/**
 * 冒泡排序（Bubble Sort）
 */
public class BubbleSort {


    /*
    https://mp.weixin.qq.com/s/iuDVZqShmg1CV6bdXVQmKw

            1.1 算法描述

        比较相邻的元素。如果第一个比第二个大，就交换它们两个；

        对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；

        针对所有的元素重复以上的步骤，除了最后一个；

        重复步骤1~3，直到排序完成。

        1.4 算法分析

        最佳情况：T(n) = O(n)
        最差情况：T(n) = O(n2)
        平均情况：T(n) = O(n2)
     */

    private static int[] array = {57,23,9,16,39,72,23,15,34,5,62,1,9};

    private static int[] bubbleSort(int[] array){
        if(array == null || array.length == 0){
            return array;
        }

//        for(int i = 0; i < array.length ; i++){
//            for(int j = 0 ; j < array.length - 1- i; j++){
//                if(array[j + 1] < array[j]){
//                    int temp = array[j + 1];
//                    array[j + 1] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }

        for(int i= 0 ;i < array.length ;i++){
            for(int j = 0 ; j < array.length - 1 -i ;j++){
                if(array[j+1] < array[j]){
                    int temp = array[j+1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    public static void main(String[] args){
        System.out.print("冒泡排序（Bubble Sort）原array:");
        for(int i : array){
            System.out.print(i+",");
        }

        System.out.println();

        array = bubbleSort(array);

        System.out.print("冒泡排序（Bubble Sort）后array:");
        for(int i : array){
            System.out.print(i+",");
        }
    }

}
