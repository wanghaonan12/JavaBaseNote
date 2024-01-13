package com.whn.controller;

import com.whn.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Wanghn
 * @date 2024/1/10 13:55
 */
@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    public void buyBook(Integer bookId, Integer userId){
        bookServiceImpl.buyBook(bookId, userId);
    }
}
