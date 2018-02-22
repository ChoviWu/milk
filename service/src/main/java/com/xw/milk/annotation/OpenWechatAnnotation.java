package com.xw.milk.annotation;

import java.lang.annotation.*;

/**
 * Created by ChoviWu on 2018/02/06
 * Description:
 */
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenWechatAnnotation {


    String methodName() default "";
    String className() default  "";
}
