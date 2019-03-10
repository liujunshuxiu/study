package study.sort;

import java.util.Arrays;

/**
 * 归并排序（Merge Sort）
 */
public class MergeSort {

    /**
     * https://mp.weixin.qq.com/s/iuDVZqShmg1CV6bdXVQmKw
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(nlogn)
     * 平均情况：T(n) = O(nlogn)
     */

    private static int[] array = {57,23,9,16,39,72,23,15,34,5,62,1,9};

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    public static void main(String[] args){

        System.out.print("归并排序（Merge Sort）原array:");
        for(int i : array){
            System.out.print(i+",");
        }

        System.out.println();

        array = MergeSort(array);

        System.out.print("归并排序（Merge Sort）后array:");
        for(int i : array){
            System.out.print(i+",");
        }
    }
}
