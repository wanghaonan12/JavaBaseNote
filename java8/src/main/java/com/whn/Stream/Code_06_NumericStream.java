package com.whn.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author WHN
 * @Date 2023/7/7 15:18
 * @description
 * @Version 1.0
 */
public class Code_06_NumericStream {

    public static void main(String[] args) {
        System.out.println("-------example1---------");
        example1();
        System.out.println("\n" + "-------example2---------");
        example2();
        System.out.println("\n" + "-------example3---------");
        example3();

    }
    static void example1(){
        List<Integer> arr = Arrays.asList(1, 3, 2, 5, 3, 3, 4);

        Stream<Integer> integerStream = arr.stream().filter(i -> i.intValue() > 3);
        Integer res = integerStream.reduce(0, Integer::sum);

        IntStream intStream = arr.stream().mapToInt(i -> i.intValue());
        int res2 = intStream.filter(i -> i > 3).sum();

        System.out.println(res + " " + res2); // 一样的，但是转换成IntStream效率更高
    }

    // 产生 a = 5 勾股数
    static void example2(){
        int a = 5;
        Stream<int[]> triples1 = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});

        triples1.forEach(t ->
                System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }

    // 产生100以内的所有勾股数
    static void example3(){
        Stream<int[]> triples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100) // a也是100内随机产生的
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        triples2.
                forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}

