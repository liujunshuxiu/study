package study.inter;

import java.lang.annotation.*;

@Target(ElementType.FIELD)  // 字段、枚举的常量
@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented  //注解包含在javadoc中：
public @interface StudentGender {

    public enum Gender{BOY, GIRL};
    Gender gender() default Gender.BOY;

}