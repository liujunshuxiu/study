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
        List<TestObject> list=new ArrayList<TestObject>();
        while(true){
            list.add(new TestObject());
        }

    }
}
