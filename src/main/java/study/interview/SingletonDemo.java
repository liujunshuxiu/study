package study.interview;

public class SingletonDemo {
    private static class SingletonDemoHolder{
        private static final SingletonDemo instance = new SingletonDemo();
    }

    private SingletonDemo (){

    }

    public static final SingletonDemo getInstance(){
        return SingletonDemoHolder.instance;
    }
}
