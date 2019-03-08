package study.sort;

/**
 * 选择排序（Selection Sort）
 */
public class SelectionSort {

    /**
     *
     * https://mp.weixin.qq.com/s/iuDVZqShmg1CV6bdXVQmKw
     *
     *
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * --------------------------------------------
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     *
     * 最佳情况：T(n) = O(n2)
     *
     * 最差情况：T(n) = O(n2)
     *
     * 平均情况：T(n) = O(n2)
     */



    private static int[] array = {57,23,9,16,39,72,23,15,34,5,62,1,9};

    public static int[] selectionSort(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }

        for(int i = 0 ; i < array.length ; i ++){
            int minIndex = i;
            for(int j = i ; j< array.length ; j ++){
                if(array[j] < array[minIndex]){  //找到最小的数
                    minIndex = j;   //将最小数的索引保存
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

        }
        return array;
    }


    public static void main(String[] args){
        System.out.print("选择排序（Selection Sort）原array:");
        for(int i : array){
            System.out.print(i+",");
        }

        System.out.println();

        array = selectionSort(array);

        System.out.print("选择排序（Selection Sort）后array:");
        for(int i : array){
            System.out.print(i+",");
        }
    }

}
