package study.sort;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序（Bucket Sort）
 */
public class BucketSort {

    /**
     * 人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     *
     * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
     *
     * 对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
     *
     * 从不是空的桶里把排好序的数据拼接起来。
     *
     *最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)　
     *
     */


    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static List<Integer> BucketSort(List<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                List<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    private static Integer[] array = {57,23,9,16,39,72,23,15,34,5,62,1,9};


    public static void main(String[] args){
        System.out.print("桶排序（Bucket Sort）原array:");
        for(int i : array){
            System.out.print(i+",");
        }

        System.out.println();

        List<Integer> ints = new ArrayList<>();

        Collections.addAll(ints,array);

        array = BucketSort(ints, 13).toArray(new Integer[0]);



        ;

        System.out.print("桶排序（Bucket Sort）后array:");
        for(int i : array){
            System.out.print(i+",");
        }
    }
}
