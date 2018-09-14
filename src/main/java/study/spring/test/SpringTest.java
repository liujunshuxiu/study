package study.spring.test;

import study.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {


    public static void main(String[] args){
        //加载配置文件(配置文件方式加载)
//        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("web/WEB-INF/spring-ioc.xml");
        //自动注入方式
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("web/WEB-INF/spring-ioc2.xml");

        //加载配置文件(@Configuration方式加载)
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);


//        AccountService accountService=applicationContext.getBean("accountService",AccountService.class);
        //多次获取并不会创建多个accountService对象,因为spring默认创建是单实例的作用域
//        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
//        accountService.doSomething();


        UserService userService= (UserService) applicationContext.getBean("userService");
        userService.done();
    }

}
