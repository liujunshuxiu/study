package main.java.study.spring.test;

import main.java.study.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {


    public static void main(String[] args){
        //加载配置文件
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("web/WEB-INF/spring-ioc.xml");

//        AccountService accountService=applicationContext.getBean("accountService",AccountService.class);
        //多次获取并不会创建多个accountService对象,因为spring默认创建是单实例的作用域
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        accountService.doSomething();
    }

}
