package com.whn.spring6.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

/**
 * @author Wanghn
 * @date 2024/1/8 15:00
 * bean scope 设置bean的状态
 */
public class D_BeanScopePropertiesTest {

    /**
     * 打印结果
     * hello word init ...
     * scope = singleton 的两个 bean ：true
     * hello word init ...
     * hello word init ...
     * scope = prototype 的两个 bean ：false
     * 所以 scope = prototype 时在获取 bean 时回去重新创建 不是单例状态
     */
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanScopeProperties.xml");
        HelloWorld helloWorldOne1 = applicationContext.getBean("helloWorldOne", HelloWorld.class);
        HelloWorld helloWorldOne2 = applicationContext.getBean("helloWorldOne", HelloWorld.class);
        System.out.println("scope = singleton 的两个 bean ："+Objects.equals(helloWorldOne1, helloWorldOne2));
        HelloWorld helloWorldTwo1 = applicationContext.getBean("helloWorldTwo", HelloWorld.class);
        HelloWorld helloWorldTwo2 = applicationContext.getBean("helloWorldTwo", HelloWorld.class);
        System.out.println("scope = prototype 的两个 bean ："+Objects.equals(helloWorldTwo1, helloWorldTwo2));
    }
}
