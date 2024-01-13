package com.whn.spring6.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Wanghn
 * @date 2024/1/8 9:52
 */
@Slf4j
class HelloWordTest {

    @Test
    void hello() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        HelloWord helloWorld =(HelloWord) classPathXmlApplicationContext.getBean("helloWorld");
        helloWorld.hello();
        log.info("is debug >>> ");
    }
}