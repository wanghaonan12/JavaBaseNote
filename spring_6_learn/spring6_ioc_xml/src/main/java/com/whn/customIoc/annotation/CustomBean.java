package com.whn.customIoc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wanghn
 * @date 2024/1/9 14:41
 * 自定义 Bean注解 将被该注解标注的类添加到容器中
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomBean {
}
