package com.whn.Stream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WHN
 * @Date 2023/7/4 13:57
 * @description 菜肴
 * @Version 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    /**
     * 菜名
     */
    String name;
    /**
     * 描述
     */
    String description;

    /**
     * 卡路里
     */
    Integer calorie;

    public static List<Dish> menu() {
        List<Dish> result = new ArrayList<>();
        result.add(Dish.builder().name("西红柿炒蛋").description("西红柿炒的蛋").calorie(100).build());
        result.add(Dish.builder().name("蛋炒西红柿").description("蛋炒的西红柿").calorie(200).build());
        result.add(Dish.builder().name("洋柿子炒蛋").description("洋柿子炒的蛋").calorie(500).build());
        result.add(Dish.builder().name("蛋炒洋柿子").description("蛋炒的洋柿子").calorie(900).build());
        result.add(Dish.builder().name("西红柿鸡蛋大乱炖").description("西红柿鸡蛋随便炒").calorie(1000).build());
        return result;
    }
}
