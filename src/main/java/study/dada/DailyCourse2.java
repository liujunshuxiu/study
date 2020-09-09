package study.dada;

public class DailyCourse2 {

    private static int[] str = new int[]{9,65,1,36,4,3,5,7,9};

    private static int k = 4;

//    public static void main(String[] args) {
//        int[] res = new int[k];
//
//        System.out.println(res.length);
//        System.out.println(res[k -1]);
//
//        for(int i = 0 ; i < str.length ; i++){
//            if(str[i] >= res[k -1] ){
//                add2Str(str[i],res);
//            }
//        }
//
//        System.out.println("Max k is :"+ res[k -1]);
//    }

    private static void add2Str(int i, int[] res) {

        for(int j = k -1 ;j >= 0 ;j--){
            if(i >= res[j]){
                continue;
            }else {
                //插入i，数字右移一位
                moveRes(i,j,res);
            }
        }
    }

    private static void moveRes(int i, int j, int[] res) {
        int m = 0;
        int a = 0;
        for(int n = j ; n < res.length ; n++){
            a = res[j + 1];
            res[j + 1] = res[j];
            res[j] = m;
            m = a;
        }
    }

    public static void main(String[] args) {
//        int ansRate = (int) ((float) 2 / 4 * 100);
//        System.out.println(ansRate);
//        int[] res = new int[]{5,4,3,2,1};
//        moveRes(4,1,res);

//        System.out.println(1572055581 - 1571133833);

        System.out.println(1590636201 - 1590632777);

    }
}
