package com.whn.dao;

/**
 * @author Wanghn
 * @date 2024/1/10 13:53
 */
public interface BookDao {
    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId, Integer price);
}
