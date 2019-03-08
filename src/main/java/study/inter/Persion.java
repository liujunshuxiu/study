package study.inter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  /// 接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented  //注解包含在javadoc中
public @interface Persion {
    String name() default "zcx";
    int age() default 18;

    String[] hobby() default {"basketball", "football"};
}
