package com.whn.Lambda;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author WHN
 * @Date 2023/6/28 16:00
 * @description lambda基础语法
 * @Version 1.0
 */
public class BasicGrammar {
    /**
     * Java8中引入了一个新的操作符，"->"，该操作符称为箭头操作符或者Lambda操作符，箭头操作符将Lambda表达式拆分成两部分；
     * 左侧: Lambda表达式的参数列表，对应的是接口中抽象方法的参数列表；
     * 右侧: Lambda表达式中所需要执行的功能(Lambda体)，对应的是对抽象方法的实现；(函数式接口(只能有一个抽象方法))
     * Lambda表达式的实质是　对接口的实现；
     */

    public static void main(String[] args) {
        //(一)、接口中的抽象方法 : 无参数，无返回值；
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("启动 Runnable");
            }
        };
        runnable.run();

        System.out.println("---------------------------lambda 表达式设置runnable");
        Runnable lambdaRunnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("lambda running runnable" + i);
            }
        };
        lambdaRunnable.run();

//        (二)、接口中的抽象方法 : 一个参数且无返回值； (若只有一个参数，那么小括号可以省略不写)
        Integer num = 1;
        Consumer<Integer> consumer = (n) -> {
            n += 10;
            System.out.println("计算后：" + n);
        };
        consumer.accept(num);

//        (三)、两个参数，有返回值，并且有多条语句 ：　要用大括号括起来，而且要写上return
        System.out.println("两个参数的表达式使用");
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("当前比较" + x + "," + y);
            return Integer.compare(y, x);
        };
        List<Integer> sortList = Arrays.asList(1, 4, 65, 7, 86, 23, 546, 2, 32, 123, 90);
        Collections.sort(sortList, comparator);
        System.out.println(sortList);


        /**
        * Java8四大内置函数式接口
        * Consumer< T >con 消费性 接口: void accept(T t)；
        * Supplier< T >sup供给型接口 : T get()；
        * Function< T , R >fun  函数式接口 : R apply (T t)；
        * Predicate< T >： 断言形接口 : boolean test(T t)；
        */

        com(5,x->{
            System.out.println("-------------------------------------------消费性接口-------------------------");
            for (int i = 0; i < 10; i++) {
                x += 10;
                System.out.println("x："+x);
            }
        });
        List<Integer> sup = sup(10, () -> Integer.valueOf((int) (Math.random() * 100)));
        System.out.println("-------------------------------------------供给性接口-------------------------");
        System.out.println(sup);
        Integer fun = fun(100, x -> 2 * x);
        System.out.println("-------------------------------------------函数性接口-------------------------");
        System.out.println(fun);
        System.out.println("-------------------------------------------断言性接口-------------------------");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 56, 67, 876, 23, 7, 9);
        Map<Integer, Boolean> pre = pre(list, x -> x > 10);
        System.out.println(pre);

    }

    /**
     * 内置函数接口Consumer是消费性接口 不会有返回值
     * @param x 消费值
     * @param consumer 消费方式
     */
    private static void com(Integer x, Consumer<Integer> consumer) {
        consumer.accept(x);
    }

    /**
     * 供给型接口 Supplier 会产生整数
     * @param supplier 产生规则
     */
    private static List<Integer> sup(Integer num,Supplier<Integer> supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    /**
     * 函数式接口 Function 有返回值
     * @param x 操作数据
     * @param function 操作方法
     * @return 返回结果
     */
    private static Integer fun(Integer x, Function<Integer,Integer> function) {
       return function.apply(x);
    }

    /**
     * 断言形接口 Predicate 返回布尔值
     * @param x 断言数据
     * @param predicate 断言方式
     * @return 断言结果
     */
    private static Map<Integer,Boolean> pre(List<Integer> x, Predicate<Integer> predicate) {
        Map<Integer,Boolean> result = new HashMap<>();
        x.forEach(integer -> {
            result.put(integer,predicate.test(integer));
        });
        return result;
    }

}
