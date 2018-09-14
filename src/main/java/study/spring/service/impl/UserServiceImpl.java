package study.spring.service.impl;

import study.spring.dao.UserDao;
import study.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class UserServiceImpl implements UserService {

    //需要注入的依赖
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    //占位符方式
    @Value("${jdbc.url}")
    private String url;

    //SpEL表达方式，其中代表xml配置文件中的id值configProperties
    @Value("#{configProperties['jdbc.username']}")
    private String userName;

    /**
     * set方法
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void done(){
        System.out.println("url:"+url);
        System.out.println("username:"+userName);
        userDao.done();
    }
}
