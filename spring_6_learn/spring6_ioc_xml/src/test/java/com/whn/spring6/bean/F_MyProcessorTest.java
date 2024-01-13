package com.whn.spring6.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Wanghn
 * @date 2024/1/9 10:58
 */
@Slf4j
class F_MyProcessorTest {

    /**
     * INFO com.whn.spring6.bean.User - 生命周期：1、创建对象
     * INFO com.whn.spring6.bean.User - 生命周期：2、设置 属性
     * INFO com.whn.spring6.bean.MyProcessor - 生命周期：※※※、自定义前置处理器
     * INFO com.whn.spring6.bean.User - 生命周期：3、初始化
     * INFO com.whn.spring6.bean.MyProcessor - 生命周期：※※※、自定义后置处理器
     * INFO com.whn.spring6.bean.F_MyProcessorTest - 生命周期：6、使用对象
     * INFO com.whn.spring6.bean.User - 生命周期：5、销毁
     */
    @Test
    public void carProcessorTest() {
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("MyProcessorLifeCycle.xml");
        User carProcessor = cp.getBean("userOne", User.class);
        log.info("生命周期：6、使用对象");
        cp.close();
    }
}