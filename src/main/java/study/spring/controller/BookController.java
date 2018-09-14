package study.spring.controller;

import study.spring.service.bean.PrototypeBean;
import study.spring.service.bean.RequestBean;
import study.spring.service.bean.SessionBean;
import study.spring.service.bean.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作用域测试
 */
@Controller
@RequestMapping(value = "bookController")
public class BookController {

    @Autowired
    private RequestBean requestBean;
    @Autowired
    private SessionBean sessionBean;
    @Autowired
    private PrototypeBean prototypeBean;
    @Autowired
    private SingletonBean singletonBean;


    @RequestMapping(value = "/test")
    public void test()
    {
        print();
    }

    public void print() {
        System.out.println("first  time singleton is :" + singletonBean);
        System.out.println("second time singleton is :" + singletonBean);

        System.out.println("first  time prototype is :" + prototypeBean);
        System.out.println("second time prototype is :" + prototypeBean);

        System.out.println("first  time requestBean is :" + requestBean);
        System.out.println("second time requestBean is :" + requestBean);

        System.out.println("first  time sessionBean is :" + sessionBean);
        System.out.println("second time sessionBean is :" + sessionBean);

        System.out.println("===========================================");
    }
}
