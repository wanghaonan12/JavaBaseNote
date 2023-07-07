package com.whn.Stream;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author WHN
 * @Date 2023/7/4 17:21
 * @description
 * @Version 1.0
 */

public class Code_04_StreamOperations1 {

    static PrintStream out;

    public static void main(String[] args) {
        out = System.out;
        out.println("-------filterTest---------");
        filterTest();
        out.println("\n" + "-------limitTest---------");
        limitTest();
        out.println("\n" + "-------skipTest---------");
        skipTest();
        out.println("\n" + "-------mapTest---------");
        mapTest();
        out.println("\n" + "-------flatMapTest1---------");
        flatMapTest();
        out.println("\n" + "-------flatMapTest2---------");
        flatMapTest2();
        out.println("\n" + "-------flatMapTest3---------");
        flatMapTest3();
    }

    static void filterTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        // 山选出偶数且没有重复
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct() // 去重
                .forEach(x -> out.print(x + " "));
        out.println();
    }

    static void limitTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().
                limit(3). // 取前3个
                forEach(x -> out.print(x + " "));
        out.println();
    }

    static void skipTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().
                skip(3). // 跳过前3个
                forEach(x -> out.print(x + " "));
        out.println();
    }

    // map里面需要的是 Function
    static void mapTest() {
        // 例子1
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().
                map(i -> i * 2). // function函数对元素进行操作并返回
                collect(Collectors.toList()).
                forEach(x -> out.print(x + " "));
        out.println();

        // 例子2
        List<String> words = Arrays.asList("aa", "bbb", "cccc", "ddddd"); // 长度分别为 2, 3, 4, 5
        words.stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(x -> out.print(x + " "));
        out.println();
    }

    // 将 words去重输出字符
    static void flatMapTest() {

        String[] words = {"He llo", "World"};
        // {h, e, l, l, o}, {w, o, r, l, d
//      stream流会在遇到终端指令后才会执行，并且关闭流
        Stream<String[]> stream = Arrays.stream(words).map(x -> x.split(""));
//        flatMap 扁平化——将数组流中的元素取出，变成一个新的流：下面就是将String[]流中的元素去除转换成String流
        Stream<String> stringStream = stream.flatMap(s -> Arrays.stream(s));
        stringStream.forEach(x -> out.print(x + " "));
        out.println();
    }

    // 拿取 list 中map的部分数据合并成另一个流
    static void flatMapTest2() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "whn" + i);
            map.put("sex", "man" );
            list.add(map);
        }
        for (int i = 0; i <4 ; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "whn" + 2);
            map.put("sex", "man" );
            list.add(map);
        }
        list.stream().flatMap(map ->Stream.of(map.get("name"))).distinct().forEach(System.out::println);

    }

    // 将嵌套的list进行扁平化输出
    static void flatMapTest3() {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> flattenedList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList); // 输出：[1, 2, 3, 4, 5, 6]

    }
}

