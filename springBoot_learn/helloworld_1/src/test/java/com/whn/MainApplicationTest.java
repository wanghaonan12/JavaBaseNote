package com.whn;

import com.whn.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: WangHn
 * @Date: 2024/1/13 10:59
 * @Description:
 */

@SpringBootTest
class MainApplicationTest {

    @Autowired
    @Qualifier("user01")
    private User user;
    @Test
    void contextLoads() {
        System.out.println(user);
    }
}