package study.spring.aop.first.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

@Aspect
public class AspectOne implements Ordered {

    /**
     * Pointcut定义切点函数
     */
    @Pointcut("execution(* study.spring.aop.first.dao.UserDao.deleteUser(..))")
    private void myPointcut(){}

    @Before("myPointcut()")
    public void beforeOne(){
        System.out.println("前置通知..AspectOne..执行顺序1");
    }

    @Before("myPointcut()")
    public void beforeTwo(){
        System.out.println("前置通知..AspectOne..执行顺序2");
    }

    @AfterReturning(value = "myPointcut()")
    public void AfterReturningThree(){
        System.out.println("后置通知..AspectOne..执行顺序3");
    }

    @AfterReturning(value = "myPointcut()")
    public void AfterReturningFour(){
        System.out.println("后置通知..AspectOne..执行顺序4");
    }

    /**
     * 定义优先级,值越低,优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}