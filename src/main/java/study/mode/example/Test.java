package study.mode.example;

public class Test {

    public static void main(String[] argv) {

        //实例化
        Movie movie = new Movie.Builder(240,8).calories(1).carbohydrate(2).fat(3).sodium(4).build();

//        String a = "a";
//        String b = "";
//        boolean flag = (a == b);
//        boolean flag1 = (a.equals(b));
//
//        System.out.print(flag);
//        System.out.print(flag1);

//        demo1();

        double x = 1,y =2,z=3;
        double a = y+=z--/++x;

        System.out.print(a);
    }

    private static int testPass(StringBuilder s1,int n){
        s1.append(" world");
        n = 8;
        return n;
    }


    private static void demo1(){
        int i =1;
        StringBuilder s2 = new StringBuilder("Hello");
        int c = testPass(s2,i);
        System.out.println(s2);
        System.out.println(i);
        System.out.println(c);
    }

}
