package com.whn.service.impl;

import com.whn.service.ComputerService;
import com.whn.service.MyFunction;
import org.springframework.stereotype.Service;

/**
 * @Author: WangHn
 * @Date: 2024/1/13 11:11
 * @Description: 计算器接口实现类
 */
@Service
public class ComputerServiceImpl implements ComputerService {
    @Override
    public double add(double a, double b) {
        return computer(a,b,(x,y)->x+y );
    }

    @Override
    public double subtract(double a, double b) {
        return computer(a,b,(x,y)->x-y );
    }

    @Override
    public double multiply(double a, double b) {
        return computer(a,b,(x,y)->x*y );
    }

    @Override
    public double divide(double a, double b) {
        return computer(a,b,(x,y)->x/y );
    }

    private double computer(double a, double b, MyFunction function){
        return function.getValue(a, b);
    }
}
