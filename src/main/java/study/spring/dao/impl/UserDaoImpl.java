package study.spring.dao.impl;

import study.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void done(){
        System.out.println("UserDaoImpl.invoke......");
    }
}
