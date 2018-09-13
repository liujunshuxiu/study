package com.LJ.study.spring.test;

import com.LJ.study.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @Test
    public void testByXml() throws Exception {
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("rescources/spring-ioc.xml");

//        AccountService accountService=applicationContext.getBean("accountService",AccountService.class);
        //多次获取并不会创建多个accountService对象,因为spring默认创建是单实例的作用域
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        accountService.doSomething();
    }
}
