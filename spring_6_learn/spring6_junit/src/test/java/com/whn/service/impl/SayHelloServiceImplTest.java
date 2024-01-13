package com.whn.service.impl;

import com.whn.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author Wanghn
 * @date 2024/1/10 13:19
 */

//两种方式均可
//方式一
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
//方式二
@SpringJUnitConfig(locations = "classpath:bean.xml")
class SayHelloServiceImplTest {

    @Autowired
    private User user;

    @Autowired
    private SayHelloServiceImpl sayHelloService;
    @Test
    void sayHello() {
        user.sayHelloWord();
        System.out.println(sayHelloService.sayHello("王富贵"));
    }
}