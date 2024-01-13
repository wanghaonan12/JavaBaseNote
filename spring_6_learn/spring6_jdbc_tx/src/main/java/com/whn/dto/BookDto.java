package com.whn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Wanghn
 * @date 2024/1/10 13:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookDto {
    private Integer book_id;
    private String book_name;
    private  Integer price;
    private Integer stock;
}
