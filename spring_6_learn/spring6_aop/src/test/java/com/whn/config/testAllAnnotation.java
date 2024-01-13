package com.whn.config;

import com.whn.service.impl.ConsumerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author Wanghn
 * @date 2024/1/11 10:21
 */
//@SpringJUnitConfig(Spring6Config.class)
@SpringJUnitConfig(locations = "classpath:bean.xml")
class testAllAnnotation {
    @Autowired
    private ConsumerImpl consumerImpl;

    /**
     * 不使用junit进行测试
     */
    @Test
    public void testDontUseJunit(){
//        使用配置类进行配置
//        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
//        使用xml进行配置
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ConsumerImpl consumerService = context.getBean("consumerImpl", ConsumerImpl.class);
        System.out.println(consumerService.calculate(1.2, 2.3));
    }

    /**
     * 使用junit进行测试
     */
    @Test
    public void testUseJunit(){
        System.out.println(consumerImpl.calculate(1.2, 2.3));
    }
}