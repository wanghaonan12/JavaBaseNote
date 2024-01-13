package com.whn.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wanghn
 * @date 2024/1/10 14:01
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
class BookControllerTest {

    @Autowired
    private BookController bookController;
    @Test
    void buyBook() {
        bookController.buyBook(1,1);
    }
}