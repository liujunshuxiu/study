package study.guava;

import com.google.common.base.Optional;

public class GuavaOPTester {
    public static void main(String args[]){
        GuavaOPTester guavaTester = new GuavaOPTester();

        Integer invalidInput = null;
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(guavaTester.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        return a.get() + b.get();
    }
}
