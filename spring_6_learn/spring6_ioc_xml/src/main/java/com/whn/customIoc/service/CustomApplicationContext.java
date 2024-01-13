package com.whn.customIoc.service;

/**
 * @author Wanghn
 * @date 2024/1/9 14:40
 * 自定义山下文
 */
public interface CustomApplicationContext {
    <T> T getBean(Class<T> clazz);
}
