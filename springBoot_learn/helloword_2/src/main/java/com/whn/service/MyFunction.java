package com.whn.service;

/**
 * @Author: WangHn
 * @Date: 2024/1/13 11:22
 * @Description: 自定义函数式接口
 */
@FunctionalInterface //函数式接口
public interface MyFunction {
    /**
     *  定义一个方法 两个double 数的操作
     * @param a
     * @param b
     * @return
     */
    public double getValue(double a,double b);
}
