package com.whn.Lambda;

import com.whn.Lambda.dto.People;
import com.whn.Lambda.service.PracticeFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author WHN
 * @Date 2023/6/28 16:21
 * @description 练习
 * @Version 1.0
 */
public class Practice {

    public static void main(String[] args) {
        //       使用lambda自定义comparator比较器
        List<People> peopleList = Arrays.asList(
                People.builder().name("whn").age(18).salary(5000).address("南京鼓楼").build(),
                People.builder().name("lxz").age(21).salary(5000).address("南京栖霞").build(),
                People.builder().name("wb").age(16).salary(7000).address("南京栖霞").build(),
                People.builder().name("hxy").age(23).salary(4000).address("徐州").build(),
                People.builder().name("czm").age(18).salary(2000).address("徐州").build()
        );

        Comparator<People> com = (p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return Integer.compare(p1.getAge(), p2.getAge());
            } else {
                return Integer.compare(p2.getSalary(), p1.getSalary());
            }
        };
        System.out.println("根据用户薪资降序，如果薪资一样根据年龄升序排序");
        Collections.sort(peopleList, com);
        peopleList.forEach(System.out::println);

        myPractice(10, 20,(x1,x2)->x1.toString()+x2);
    }

    /**
     *  自定义泛型函数式接口方法
     * @param x x
     * @param y y
     * @param pf pf
     */
    private static void myPractice(Integer x, Integer y, PracticeFunction<Integer, String> pf) {
        String computer = pf.computer(x, y);
        System.out.println(computer);
    }

}
