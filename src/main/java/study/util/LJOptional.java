package study.util;

import study.guava.GuavaOPTester;

import java.util.Optional;

public class LJOptional {
    public static void main(String args[]){
        LJOptional guavaTester = new LJOptional();

        Integer invalidInput = null;
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(guavaTester.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        return a.get() + b.get();
    }
}
