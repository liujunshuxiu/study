package study.spring.ioc.dao.impl;

import study.spring.ioc.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void done(){
        System.out.println("UserDaoImpl.invoke......");
    }
}
