package com.whn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 14:13
 * @Description: 用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String userName;
    private String password;
}
