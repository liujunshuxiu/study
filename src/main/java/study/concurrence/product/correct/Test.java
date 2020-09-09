package study.concurrence.product.correct;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // 仓库
        List<Object> container = new ArrayList<>();

        new Producer("老王", container).start();
        new Consumer("小芳", container).start();
        new Producer("老李", container).start();
        new Consumer("小荷", container).start();
        new Producer("老张", container).start();

        new Consumer("小花", container).start();
        new Producer("老刘", container).start();
        new Consumer("小妞", container).start();
        new Consumer("小米", container).start();
        new Producer("老马", container).start();

    }
}
