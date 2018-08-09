package com.LJ.study.test;

public class transTest {


    String str = new String("good");
    char [] chars = {'a','b','c'};



    public static void main(String[] args){

        int i = 1;
        System.out.println(i++);
        System.out.println(++i);

//        transTest trans = new transTest();
//        String abc = new String("fuck");
//        char [] chars = {'d','d','d'};
//
//        trans.change(abc,chars);

//        System.out.println(trans.str);
//        System.out.println(trans.chars);

//        System.out.println(abc);
//        System.out.println(chars);
    }

    public static void change(String str,char[] chars){
        str +="hello";
        chars= new char[]{'g', 'g', 'g', 'g'};
    }


}
