package study.newcoder;

import java.util.Scanner;

public class NowCoderTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strs = str.split(";");
        int x = 0;
        int y = 0;

        for(int i = 0 ; i< strs.length ;i++){
            String value = strs[i];
            if(!value.matches("[WSAD][0-9]{1,2}")){
                continue;
            }
            String dis = value.substring(0,1);
            int num = Integer.parseInt(value.substring(1));
            switch (dis){
                case "W":
                    y += num;
                    break;
                case "S":
                    y -= num;
                    break;
                case "A":
                    x -= num;
                    break;
                case "D":
                    x += num;
                    break;
                default:
                    break;
            }


        }
        System.out.println(x+","+y);
    }
}
