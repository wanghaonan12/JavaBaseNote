package com.whn.service.impl;

import com.whn.dao.impl.BookDaoImpl;
import com.whn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Wanghn
 * @date 2024/1/10 13:54
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDaoImpl bookDaoImpl;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void buyBook(Integer bookId, Integer userId) {
        Integer priceByBookId = bookDaoImpl.getPriceByBookId(bookId);
        bookDaoImpl.updateStock(bookId);
        int i = 1/ 0;
        bookDaoImpl.updateBalance(userId,priceByBookId);
    }
}
