package com.whn.Reflect.dto;

import com.whn.Reflect.Annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WHN
 * @Date 2023/7/7 15:47
 * @description
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @MyAnnotation(value = 1,key = "name")
    private String name;
    @MyAnnotation(value = 2,key = "age")
    private int age;

    private void sayHello() {
        System.out.println("Hello, I'm " + name + ","+age +"years old now!");
    }
}
