package com.whn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Wanghn
 * @date 2024/1/10 13:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Emp {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
