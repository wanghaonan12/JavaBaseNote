package com.whn.Reflect.dto;

import com.whn.Reflect.Annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author WHN
 * @Date 2023/7/7 17:02
 * @description
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    @MyAnnotation(value = 1,key = "name")
    private String name;
    @MyAnnotation(value = 2,key = "age")
    private Integer age;
    private String breed;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, breed);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                '}';
    }
}
