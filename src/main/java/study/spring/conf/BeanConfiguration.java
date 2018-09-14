package study.spring.conf;

import study.spring.dao.AccountDao;
import study.spring.dao.impl.AccountDaoImpl;
import study.spring.service.AccountService;
import study.spring.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean方式配置类关系，和spring-ioc.xml效果一样
 * 尽量避免使用这种方式，太混乱
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    }

    @Bean
    public AccountService accountService(){
        AccountServiceImpl bean = new AccountServiceImpl();
        bean.setAccountDao(accountDao());
        return bean;
    }
}
