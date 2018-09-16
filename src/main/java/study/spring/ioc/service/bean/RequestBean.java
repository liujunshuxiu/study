package study.spring.ioc.service.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestBean {
}
