package com.whn.Stream;

import com.whn.Stream.dto.Dish;

import java.util.stream.Collectors;

/**
 * @Author WHN
 * @Date 2023/7/4 14:21
 * @description 流的延迟性质
 * @Version 1.0
 */
public class Code_02_StreamDelayFeature {
    public static void main(String[] args) {
        System.out.println("don`t have terminal ----------------------------------------");

        Dish.menu().stream()
                .filter(dish -> {
                    System.out.println("don`t have terminal doing filter:" + dish.getName());
                    return true;
                })
                .map(dish -> {
                    System.out.println("don`t have terminal doing Mapping" + dish.getName());
                    return dish.getName();
                });
        System.out.println("have terminal --------------------------------------");
        Dish.menu().stream()
                .filter(dish -> {
                    System.out.println("have terminal doing filter:" + dish.getName());
                    return true;
                })
                .map(dish -> {
                    System.out.println("have terminal doing Mapping" + dish.getName());
                    return dish.getName();
                }).collect(Collectors.toList());
    }
}
