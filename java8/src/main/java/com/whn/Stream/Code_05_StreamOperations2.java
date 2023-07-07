package com.whn.Stream;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @Author WHN
 * @Date 2023/7/7 14:59
 * @description
 * @Version 1.0
 */
public class Code_05_StreamOperations2 {

    static PrintStream out;

    public static void main(String[] args) {
        out = System.out;
        out.println("-------matchTest---------");
        matchTest();
        out.println("\n" + "-------findTest---------");
        findTest();
        out.println("\n" + "-------reduceTest---------");
        reduceTest();
    }

    static void matchTest(){
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        out.println(arr.stream().allMatch(i -> i > 10));
        out.println(arr.stream().anyMatch(i -> i > 6));
        out.println(arr.stream().noneMatch(i -> i < 0));
    }

    static void findTest(){
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> any = arr.stream().filter(i -> i % 2 == 0).findAny();
        out.println(any.get());
        Optional<Integer> first = arr.stream().filter(i -> i % 2 == 0).findFirst();
        first.ifPresent(out::println);
        out.println(first.get()); //没有就抛出 NoSuchElementException
        out.println(first.orElse(-1)); // 如果first为空就输出-1
        System.out.println(first.filter(i -> i == 2).get()); // Optional还会产生一个stream
        System.out.println(find(arr, -1, i -> i > 10)); // 自己写的一个防止空指针的，而Optional中有一个已经存在的
    }

    /**
     *
     * @param values
     * @param defaultValue
     * @param predicate  参数为此，提供一个test方法，返回boolean
     * @return
     */
    static int find(List<Integer> values, int defaultValue, Predicate<Integer> predicate){
        for(int val : values){
//            使用谓词test判断是否满足谓词条件条件
            if(predicate.test(val))
                return val;
        }
        return defaultValue;
    }

    // reduce 也是一个terminal的操作
    static void reduceTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum); // 输出：15，计算了所有元素的和
        System.out.println("获取最大值");
        System.out.println(numbers.stream().reduce(Integer::max).get());

    }
}
