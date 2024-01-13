package com.whn.spring6.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Wanghn
 * @date 2024/1/8 11:03
 * bean 创建的基础练习
 */
class A_HelloWordTest {

    @Test
    void getHelloBeanByClass() {
        //通过class获取bean
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
         HelloWorld helloWord = applicationContext.getBean(HelloWorld.class);
         helloWord.hello();
    }

    @Test
    void getHelloBeanByClassAndName() {
        //通过class和name获取bean
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
         HelloWorld helloWord = applicationContext.getBean("helloWorld", HelloWorld.class);
         helloWord.hello();
    }
}