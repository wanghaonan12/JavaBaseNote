package com.whn.Reflect;

import com.whn.Reflect.dto.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @Author WHN
 * @Date 2023/7/7 15:48
 * @description 反射引入
 * @Version 1.0
 */
public class Code_01_ReflectBringIn {
    public static void main(String[] args) throws Exception {
        // 通过字符串创建 Person 对象
        Class<?> personClass = Class.forName("Person");
        Person person = (Person) personClass.getDeclaredConstructor(String.class, int.class)
                .newInstance("Alice", 25);

        // 访问私有字段
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        int age = (int) ageField.get(person);
        System.out.println("Age: " + age);

        // 调用私有方法
        Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
        sayHelloMethod.setAccessible(true);
        sayHelloMethod.invoke(person);
    }
}
