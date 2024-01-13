package com.whn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Wanghn
 * @date 2024/1/10 13:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private Integer user_id;
    private String username;
    private Integer balance;
}
