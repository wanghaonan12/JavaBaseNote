package com.whn.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Wanghn
 * @date 2024/1/8 11:35
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Clazz {
    private Integer clazzId;

    private String clazzName;

    private List<Student> students;
}
