package com.whn.Reflect.dto;

/**
 * @Author WHN
 * @Date 2023/7/7 15:47
 * @description
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void sayHello() {
        System.out.println("Hello, I'm " + name);
    }
}
