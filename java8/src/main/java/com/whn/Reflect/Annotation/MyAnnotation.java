package com.whn.Reflect.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author WHN
 * @Date 2023/7/7 16:57
 * @description 自定义注解
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String key();
    int value();
}
