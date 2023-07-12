package com.whn.Reflect;

import com.whn.Reflect.Annotation.MyAnnotation;
import com.whn.Reflect.dto.Dog;
import com.whn.Reflect.dto.FieldInfo;
import com.whn.Reflect.dto.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author WHN
 * @Date 2023/7/7 16:56
 * @description 反射练习
 * @Version 1.0
 */
public class Code_03_Practice {
    public static void main(String[] args) {

        System.out.println("获取类的方法方法");
//      获取使用类的方法需要知道类的名字和参数
        String methodName = "sayHello";
        Person person = new Person();
        person.setAge(14);
        person.setName("whn");
        try {
            Method method = Person.class.getDeclaredMethod(methodName);
//            设置可以访问
            method.setAccessible(true);
            method.invoke(person);
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("反射创建对象");
        try {
//            创建有参构造器将参数类型放进去，注意顺序要对，创建无参的话，可以不用传参
            Constructor<Dog> declaredConstructor = Dog.class.getDeclaredConstructor(String.class,Integer.class,String.class);
            declaredConstructor.setAccessible(true);
            Dog dog = declaredConstructor.newInstance("王富贵", 12, "藏獒");
            System.out.println(dog);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
