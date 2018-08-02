package com.example.concurrencyday1.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不推荐写法
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//注解存在的范围
public @interface NotRecommend {
    String value() default  "";
}
