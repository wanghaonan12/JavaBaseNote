package com.whn.spring6.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Wanghn
 * @date 2024/1/9 10:03
 * 使用 User 验证 bean 的生命周期
 */
@Slf4j
class E_UserTest {

    /**
     * 输出结果
     *  com.whn.spring6.bean.User - 生命周期：1、创建对象
     *  com.whn.spring6.bean.User - 生命周期：2、设置 属性
     *  com.whn.spring6.bean.User - 生命周期：3、初始化
     *  com.whn.spring6.bean.E_UserTest - 生命周期：4、通过IOC容器获取bean并使用
     *  com.whn.spring6.bean.User - 生命周期：5、销毁
     */
    @Test
    public void testOne(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("UserLifeCycle.xml");
        User user = ac.getBean("userOne", User.class);
        log.info("生命周期：4、通过IOC容器获取bean并使用");
        ac.close();
    }
}