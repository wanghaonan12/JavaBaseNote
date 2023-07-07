package com.whn.Lambda.service;

/**
 * @Author WHN
 * @Date 2023/6/30 15:23
 * @description
 * @Version 1.0
 */
@FunctionalInterface
public interface MyFunction {
    /**
     *  计算类函数接口
     * @param x x
     * @param y y
     * @return new number
     */
    Integer computer(Integer x, Integer y);
}
