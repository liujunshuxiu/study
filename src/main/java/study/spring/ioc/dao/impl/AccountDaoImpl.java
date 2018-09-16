package study.spring.ioc.dao.impl;

import study.spring.ioc.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("addAccount....");
    }
}