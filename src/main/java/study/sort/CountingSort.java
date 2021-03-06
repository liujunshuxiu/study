package study.sort;

import java.util.Arrays;

/**
 * 计数排序（Counting Sort）
 */
public class CountingSort {

    /**
     *
     * 卧槽这是我在业务中最常用的计数方式，好好看看他是怎么不用map保存每个数字有多少个的！
     * 它拿另外一个数组作为记录，新数组下标位对应原数组值，牛逼了，但是这种方式很占用空间
     *
     *
     * 找出待排序的数组中最大和最小的元素；
     *
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     *
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     *
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     *
     *最佳情况：T(n) = O(n+k)
     *
     * 最差情况：T(n) = O(n+k)
     *
     * 平均情况：T(n) = O(n+k)
     *
     */

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    private static int[] array = {57,23,9,16,39,72,23,15,34,5,62,1,9};


    public static void main(String[] args){
        System.out.print("计数排序（Counting Sort）原array:");
        for(int i : array){
            System.out.print(i+",");
        }

        System.out.println();

        array = CountingSort(array);

        System.out.print("计数排序（Counting Sort）后array:");
        for(int i : array){
            System.out.print(i+",");
        }
    }
}
