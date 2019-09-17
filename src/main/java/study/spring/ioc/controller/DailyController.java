package study.spring.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "dailyController")
public class DailyController {

    static class TestObject{}

    @RequestMapping(value = "/dead")
    public void dead()
    {
        System.out.println("进入dead");
        List<TestObject> list=new ArrayList<TestObject>();
        int i = 0;
        while(1 < 100000){
            list.add(new TestObject());
        }

    }
}
