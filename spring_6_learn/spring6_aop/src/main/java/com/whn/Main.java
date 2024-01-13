package com.whn;

import com.whn.handler.PoxyFactory;
import com.whn.service.ConsumerService;
import com.whn.service.impl.ConsumerImpl;

/**
 * @author Wanghn
 * @date 2024/1/9 16:07
 */
public class Main {
    public static void main(String[] args) {
        ConsumerService proxy = new PoxyFactory<ConsumerService>(new ConsumerImpl()).getProxy();
        double calculate = proxy.calculate(1.2, 2.4);
        System.out.println(calculate);
    }
}