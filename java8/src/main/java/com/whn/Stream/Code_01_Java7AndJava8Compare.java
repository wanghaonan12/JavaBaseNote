package com.whn.Stream;

import com.whn.Stream.dto.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author WHN
 * @Date 2023/7/4 13:56
 * @description 流的引入
 * @Version 1.0
 */
public class Code_01_Java7AndJava8Compare {
    public static void main(String[] args) {
        System.out.println(java7());
        System.out.println(java8());

    }
    //    热量>400 的菜肴 的 名称, 返回结果按照从低到高排序， Java7的写法
    static List<String> java7() {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : Dish.menu()) {
            if (d.getCalorie() > 400) {
                lowCaloricDishes.add(d);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalorie(), d2.getCalorie());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    //    热量>400 的菜肴 的 名称, 返回结果按照从低到高排序， Java8的写法
    static List<String> java8() {
        return Dish.menu().stream()
                .filter(dish -> dish.getCalorie() > 400)
                .sorted(Comparator.comparing(Dish::getCalorie))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
