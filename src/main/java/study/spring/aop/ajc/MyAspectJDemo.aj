package study.spring.aop.ajc;

/**
 * 使用aspect类需要修改编译方式。改为ajc方式
 * 因为aspect类是编译器将切片代码织入java文件，原声的java编译器不支持
 */
public aspect MyAspectJDemo {

//    private static Log log = LogFactory.getLog(MyAspectJDemo.ljclass);
//    public MyAspectJDemo() {
//        log.info("create MyAspectJDemo instance");
//    }


    /**
     * 定义切点,日志记录切点
     */
    pointcut recordlog():call(* study.spring.aop.ajc.HelloWord.sayHello(..));

    /**
     * 定义切点,权限验证(实际开发中日志和权限一般会放在不同的切面中,这里仅为方便演示)
     */
    pointcut authCheck():call(* study.spring.aop.ajc.HelloWord.sayHello(..));

    /**
     * 定义前置通知!
     */
    before():authCheck(){
        System.out.println("sayHello方法执行前验证权限");
    }

    /**
     * 定义后置通知
     */
    after():recordlog(){
        System.out.println("sayHello方法执行后记录日志");
    }
}
