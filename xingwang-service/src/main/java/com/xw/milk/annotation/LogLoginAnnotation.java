package com.xw.milk.annotation;

import java.lang.annotation.*;

/**
 * Created by ChoviWu on 2018/02/06
 * Description:记录日志切面注解
 */
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogLoginAnnotation {

    String moduleName() default "";
    String methodName() default "";
    String value() default "";
}
