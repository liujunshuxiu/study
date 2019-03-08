package study.sort;

/**
 * 希尔排序（Shell Sort）
 */
public class ShellSort {

    /**
     *
     * https://mp.weixin.qq.com/s/iuDVZqShmg1CV6bdXVQmKw
     *
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     *
     * 按增量序列个数k，对序列进行k 趟排序；
     *
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * 最佳情况：T(n) = O(nlog2 n)
     * 最坏情况：T(n) = O(nlog2 n)
     * 平均情况：T(n) =O(nlog2n)　
     */

    private static int[] array = {57,23,9,16,39,72,23,15,34,5,62,1,9};

    public static int[] shellSort(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }

        int len = array.length;
        int temp,gap = len >> 1;

        while (gap > 0){
            for (int i = gap ; i < len ; i ++){
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap = gap >> 1;
        }
        return array;
    }


    public static void main(String[] args){

        System.out.print("希尔排序（Shell Sort）原array:");
        for(int i : array){
            System.out.print(i+",");
        }

        System.out.println();

        array = shellSort(array);

        System.out.print("希尔排序（Shell Sort）后array:");
        for(int i : array){
            System.out.print(i+",");
        }
    }
}
