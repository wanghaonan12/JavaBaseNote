package com.whn.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Wanghn
 * @date 2024/1/8 11:19
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String[] hobbies;

    private Map<String, Teacher> teacherMap;

    private Clazz clazz;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", teacherMap=" + teacherMap +
                ", clazz=" + clazz +
                '}';
    }
}
