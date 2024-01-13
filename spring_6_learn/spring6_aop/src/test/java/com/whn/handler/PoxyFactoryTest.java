package com.whn.handler;

import com.whn.service.ConsumerService;
import com.whn.service.impl.ConsumerImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wanghn
 * @date 2024/1/11 10:31
 */
class PoxyFactoryTest {

    @Test
    public void test(){
        ConsumerService proxy = new PoxyFactory<ConsumerService>(new ConsumerImpl()).getProxy();
        double calculate = proxy.calculate(1.2, 2.4);
        System.out.println(calculate);
    }
}