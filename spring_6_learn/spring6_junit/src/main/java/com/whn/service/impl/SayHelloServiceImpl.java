package com.whn.service.impl;

import com.whn.service.SayHelloService;
import org.springframework.stereotype.Component;

/**
 * @author Wanghn
 * @date 2024/1/10 13:18
 */
@Component
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
