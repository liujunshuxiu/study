package test;

public class LJTest {
    public static void main(String[] args){
        System.out.printf("字母a的大写是：%c %n", 'A');

        System.out.printf("坐标被移动到了，x:%f,y:%f", 99.1,-99.2);

        double xp = (double)(Math.random() * 10);
        double yp = (double)(Math.random() * 10);
        System.out.println("坐标被移动到了，x:"+xp+",y:"+yp);
        System.out.println(String.format("坐标被移动到了，x:%f,y:%f",xp,yp));
    }
}
