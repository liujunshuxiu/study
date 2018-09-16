package study.spring.aop.ajc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class HelloWord {
    private static Log log = LogFactory.getLog(HelloWord.class);
    public HelloWord() {
        log.info("create HelloWord instance");
    }


    public void sayHello(){
        System.out.println("hello world !");
    }


    public static void main(String args[]){
        BasicConfigurator.configure(); //自动快速地使用缺省Log4j环境。

        HelloWord helloWord =new HelloWord();
        helloWord.sayHello();
    }
}
