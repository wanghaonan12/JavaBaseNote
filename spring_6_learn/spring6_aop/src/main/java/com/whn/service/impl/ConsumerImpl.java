package com.whn.service.impl;

import com.whn.service.ConsumerService;
import org.springframework.stereotype.Service;

/**
 * @author Wanghn
 * @date 2024/1/9 20:39
 */
@Service
public class ConsumerImpl implements ConsumerService {
    @Override
    public double calculate(double a, double b) {
        return a+b;
    }

    @Override
    public double subtract(double a, double b) {
        return a-b;
    }

    @Override
    public double multiply(double a, double b) {
        return a*b;
    }

    @Override
    public double divide(double a, double b) {
        return a/b;
    }
}
