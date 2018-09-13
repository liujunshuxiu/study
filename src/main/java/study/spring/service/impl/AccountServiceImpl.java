package main.java.study.spring.service.impl;

import main.java.study.spring.dao.AccountDao;
import main.java.study.spring.service.AccountService;

public class AccountServiceImpl implements AccountService {

    /**
     * 需要注入的对象
     */
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void doSomething() {
        System.out.println("AccountServiceImpl#doSomething......");
        accountDao.addAccount();
    }
}
