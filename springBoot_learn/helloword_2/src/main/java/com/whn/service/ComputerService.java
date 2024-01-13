package com.whn.service;

/**
 * @Author: WangHn
 * @Date: 2024/1/13 11:10
 * @Description: 计算器接口服务
 */
public interface ComputerService {

    /**
     *  计算方法加
     * @param a
     * @param b
     * @return
     */
    double add(double a, double b);

    /**
     * 计算方法减
     * @param a
     * @param b
     * @return
     */
    double subtract(double a, double b);

    /**
     * 计算方法乘
     * @param a
     * @param b
     * @return
     */
    double multiply(double a, double b);

    /**
     * 计算方法除
     * @param a
     * @param b
     * @return
     */
    double divide(double a, double b);
}
