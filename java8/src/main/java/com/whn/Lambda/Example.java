package com.whn.Lambda;

import com.whn.Lambda.dto.People;
import com.whn.Lambda.service.Impl.LambdaFilterAge;
import com.whn.Lambda.service.Impl.LambdaFilterSalary;
import com.whn.Lambda.service.LambdaService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author WHN
 * @Date 2023/6/28 15:59
 * @description lambda表达式的引入案例
 * @Version 1.0
 */
public class Example {

    public static void main(String[] args) {
//        peoplelist
        List<People> peopleList = Arrays.asList(
                People.builder().name("whn").age(18).salary(5000).address("南京鼓楼").build(),
                People.builder().name("lxz").age(21).salary(10000).address("南京栖霞").build(),
                People.builder().name("wb").age(16).salary(7000).address("南京栖霞").build(),
                People.builder().name("hxy").age(23).salary(4000).address("徐州").build(),
                People.builder().name("czm").age(18).salary(2000).address("徐州").build()
        );
//        使用sort对peoplelist进行排序，重写Comparator方法
/**
 * lambda 语法引入
 */
//        使用传统方法进行重写
        peopleList.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        System.out.println("使用传统方法重写Comparator方法");
        peopleList.forEach(System.out::println);

//        使用lambda表达式进行编写Comparator
        System.out.println("使用lambda重写Comparator方法");
        ArrayList<People> peopleList2 = new ArrayList<>(peopleList);
        peopleList2.sort((x, y) -> Integer.compare(y.getAge(), x.getAge()));
        peopleList2.forEach(System.out::println);

        /**
         * 现在我们要找出年纪大于等于18，工资高于5000的人
         */
        System.out.println("传统传统--------------------------传统过滤年纪大于等于18，切工资高于5000的人");
        LambdaFilterSalary lambdaFilterSalary = new LambdaFilterSalary();
        LambdaFilterAge lambdaFilterAge = new LambdaFilterAge();
        List<People> selectAge = lambdaFilterAge.doSelect(peopleList2);
        System.out.println("年纪大于18");
        selectAge.forEach(System.out::println);
        List<People> selectSalary = lambdaFilterSalary.doSelect(peopleList2);
        System.out.println("工资大于5000");
        selectSalary.forEach(System.out::println);

        /**
         * 传统优化方法:一
         * 使用策略模式来优化
         */
        System.out.println("传统优化方法:一");
        optimizeCustom(peopleList2,new LambdaFilterAge());
        optimizeCustom(peopleList2,new LambdaFilterSalary());

        /**
         * 传统优化方法:二
         * 使用匿名内部类优化
         */
        System.out.println("传统优化方法:二");
        optimizeCustom(peopleList2, new LambdaService<People>() {
            @Override
            public List<People> doSelect(List<People> list) {
                List<People> result = new ArrayList<>();
                for (People people : list) {
                    if (people.getSalary()>5000 && people.getAge() >18) result.add(people);
                }
                return result;
            }
        });

        /**
         * 进入正题使用lambda表达式优化
         */
        System.out.println("进入正题使用lambda表达式优化!");
        optimizeCustom(peopleList2,list -> {
            List<People> result = new ArrayList<>();
            for (People people : list) {
                if (people.getSalary()>5000 && people.getAge() >18) result.add(people);
            }
            return result;
        });

    }

    /**
     *  优化方法
     * @param list 列表
     * @param service select服务接口类
     */
    public static  void optimizeCustom(List<People> list, LambdaService<People> service) {
        System.out.println("optimize select method！");
        service.doSelect(list).forEach(System.out::println);
    }
}
