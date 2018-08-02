package com.example.concurrencyday1.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 线程不安全
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//注解存在的范围
public @interface NotThreadSafe {
    String value() default  "";
}
