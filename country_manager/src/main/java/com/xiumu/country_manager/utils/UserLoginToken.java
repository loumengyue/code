package com.xiumu.country_manager.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 岐神~汤圆
 * @Description:  需要登录时候才需要的注解
 * @Attention:
 * @date: 2021/3/3 19:18
 * @version:1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}