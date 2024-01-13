package com.whn.service;

/**
 * @author Wanghn
 * @date 2024/1/9 20:39
 * 计算器类
 *
加，减，乘，除
Add, subtract, multiply, divide
 */
public interface ConsumerService {
    double calculate(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);

}
