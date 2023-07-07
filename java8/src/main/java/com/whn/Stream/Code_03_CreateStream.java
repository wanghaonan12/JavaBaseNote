package com.whn.Stream;

import com.whn.Stream.dto.Dish;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author WHN
 * @Date 2023/7/4 14:31
 * @description 流的创建
 * @Version 1.0
 */
public class Code_03_CreateStream {
    public static void main(String[] args) {
        System.out.println("---------------------------formValus-----------------------------");
        formValus().forEach(System.out::println);
        System.out.println("---------------------------formArrays-----------------------------");
        formArrays().forEach(System.out::println);
        System.out.println("---------------------------formFile-----------------------------");
//        formFile().forEach(System.out::println);
        formFile().filter(s -> s.length()<20).forEach(System.out::println);
        System.out.println("---------------------------formIterate-----------------------------");
        formIterate().forEach(System.out::println);
        System.out.println("---------------------------fromGenerate-----------------------------");
        fromGenerate().forEach(System.out::println);
    }

    /**
     * 使用Stream.of添加value创建stream
     *
     * @return
     */
    static Stream<String> formValus() {
        return Stream.of("aa", "bb", "cc", "dd");
    }

    /**
     * 使用Array创建stream
     *
     * @return
     */
    static Stream<String> formArrays() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        return list.stream();
    }

    /**
     * 通过File创建stream
     *
     * @return
     */
    static Stream<String> formFile() {
        Path path = Paths.get("java8/src/main/java/com/whn/Stream/dto/Dish.java");
        Stream<String> lines;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    /**
     * 函数创建的无限流
     *
     * @return
     */
    static Stream<Integer> formIterate() {
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(10);
        return limit;
    }

    /**
     * 创建自定义的流
     *
     * @return
     */
    static Stream<Dish> fromGenerate() {
        //需要 Supplier 供给接口
        Stream<Dish> limit = Stream.generate(()-> {
            int i = new Random().nextInt(4);
            List<Dish> menu = Dish.menu();
            return menu.get(i);
        }).limit(5);
        return limit;
    }
}
