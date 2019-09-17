package study.spring.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "dailyController")
public class DailyController {

    static List<TestObject> list = new ArrayList<TestObject>();

    static final Object obj = new Object();

    static class TestObject {
        static final Object testObj = obj;
    }

    @RequestMapping(value = "/dead")
    public void dead() {
        System.out.println("进入dead");
        int i = 0;

        while (i++ < 100000) {
            list.add(new TestObject());
        }

        System.out.println("出入dead");
    }
}
