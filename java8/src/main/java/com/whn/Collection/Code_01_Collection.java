package com.whn.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author WHN
 * @Date 2023/7/24 16:47
 * @description
 * @Version 1.0
 */
public class Code_01_Collection {
    public static void main(String[] args) {
        Collection<String> c_1 = new ArrayList<>();
        Collection<String> c_2 = new ArrayList<>();
        Collection<String> c_3 = new ArrayList<>();
        c_1.add("李白");
        c_1.add("杜甫");
        System.out.println("渲染 c_1");
        c_1.forEach(System.out::println);
        System.out.println("");

        c_2.add("王维");
        c_2.add("李清照");
        c_1.addAll(c_2);
        System.out.println("渲染 addAll 之后的 c_1");
        c_1.forEach(System.out::println);
        System.out.println("");


        c_1.remove("李白");
        System.out.println("渲染 remove 李白 之后的 c_1");
        c_1.forEach(System.out::println);
        System.out.println("");


        c_1.remove(c_2);
        System.out.println("渲染 remove c_2 之后的 c_1");
        c_1.forEach(System.out::println);
        System.out.println("");


        c_2.clear();
        System.out.println("渲染 clear 之后的 c_2");
        c_2.forEach(System.out::println);
        System.out.println("");


        System.out.println("c_1 是否存在李白"+c_1.contains("李白"));
        System.out.println("c_1 是否存在李清照"+c_1.contains("李清照"));
        System.out.println("c_1 的大小："+c_1.size());
        System.out.println("c_1 是否是空的"+ c_1.isEmpty());
        c_3.addAll(c_1);
        System.out.println("c_1 是否equals等于 c_2"+ c_1.equals(c_2));
        System.out.println("c_1 是否equals等于 c_3"+ c_1.equals(c_3));

//        注意这个==是判断是否拥有相同地址 所以c_1除了它本身和任何比较都是false，只有equals才是比较值
        System.out.println("c_1 是否==等于 c_2"+ (c_1==c_3));
        System.out.println("");


        Object[] strings = c_1.toArray();
        System.out.println("转换成数组");
        System.out.println(strings);
        System.out.println("");

        System.out.println("stream流");
        c_1.stream().forEach(System.out::print);
        System.out.println("");
//      并行stream 速度更快适合大数据量的处理，但是需要注意线程安全问题
        System.out.println("parallelStream 并行流");
        c_1.parallelStream().forEach(System.out::print);
        System.out.println("\n");


        System.out.println("迭代器遍历");
//      迭代器遍历
        Iterator<String> iterator = c_1.iterator();
        while (iterator.hasNext()) {//是否拥有下一个，如果有返回true
            System.out.println(iterator.next());//取出下一个位置的值并下移
        }
    }
}
