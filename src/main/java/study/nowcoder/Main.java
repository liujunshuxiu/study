package study.nowcoder;
import java.util.*;
import java.util.stream.Collectors;

//public class Main{
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        in.nextLine();
//        String str = in.nextLine();
//        String s[]=str.split(" ");
//        Arrays.sort(s);
//        System.out.println(Arrays.stream(s).collect(Collectors.joining(" ")));
//    }
//}}


        import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String s[]=str.split(" ");
            Arrays.sort(s);
            System.out.println(Arrays.stream(s).collect(Collectors.joining(",")));
        }
    }

}