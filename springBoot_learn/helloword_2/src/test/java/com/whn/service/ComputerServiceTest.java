package com.whn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author: WangHn
 * @Date: 2024/1/13 11:26
 * @Description:
 */
@SpringBootTest
class ComputerServiceTest {

    @Autowired
    private ComputerService computerService;
    @Test
    @DisplayName("加法测试")
    void add() {
        //运行结果要一致才通过测试
        assertEquals(computerService.add(1, 2),3);
    }

    @Test
    @DisplayName("减法测试")
    void subtract() {
        //运行结果要不一致通过测试
        assertNotEquals(computerService.add(2, 2),3);
    }

    @Test
    @DisplayName("乘法测试")
    void multiply() {
        double multiply = computerService.multiply(1, 1);
        boolean equals = Double.valueOf(multiply).equals(1.0);
        //运行结果为True通过测试
        Assertions.assertTrue(false);
    }

    @Test
    @DisplayName("除法测试")
    void divide() {
        System.out.println(computerService.divide(10, 5));
        //运行结果不为null通过测试
        assertNotNull(computerService.divide(10, 5));
    }
}