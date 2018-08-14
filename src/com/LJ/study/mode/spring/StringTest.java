package com.LJ.study.mode.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class StringTest {

    public static void main(String[] args){
        ApplicationContext context = new FileSystemXmlApplicationContext("C:/临时/applicationContext.xml");
    }
}
