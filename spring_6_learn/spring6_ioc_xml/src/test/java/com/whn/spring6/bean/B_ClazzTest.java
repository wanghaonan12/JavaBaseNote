package com.whn.spring6.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Wanghn
 * @date 2024/1/8 13:25
 * clzz 类的 bean 测试
 */
class B_ClazzTest {

    @Test
    public void createClazzTwoBeanTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Clazz clazzTwo = applicationContext.getBean("clazzTwo", Clazz.class);
        System.out.println(clazzTwo);
    }

}