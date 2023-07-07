package com.whn.Lambda;

import com.whn.Lambda.service.MyFunction;

/**
 * @Author WHN
 * @Date 2023/6/28 16:01
 * @description 函数式接口
 * @Version 1.0
 */
public class FunctionalInterface {
    /**
     * 若接口中只有一个抽象方法的接口称为函数式接口；
     * 可以使用注解@FunctionlInterface来标识，可以检查是否是函数式接口； 如 MyFunction 接口
     */

    /**
     * 使用了 MyFunction 的函数式接口
     * @param x x
     * @param y y
     * @param myFunction 函数式接口
     * @return number
     */
    public static Integer CustomerComputer(Integer x, Integer y, MyFunction myFunction) {
        return myFunction.computer(x, y);
    }

    public static void main(String[] args) {
        Integer numX = 10;
        Integer numY = 5;

        System.out.println("--------------------加法计算");
        Integer add = CustomerComputer(numX, numY, ((x, y) -> x + y));
        System.out.println(add);

        System.out.println("--------------------减法计算");
        Integer sub = CustomerComputer(numX, numY, ((x, y) -> x - y));
        System.out.println(sub);


        System.out.println("--------------------乘法计算");
        Integer mul = CustomerComputer(numX, numY, ((x, y) -> x * y));
        System.out.println(mul);



        System.out.println("--------------------触法计算");
        Integer div = CustomerComputer(numX, numY, ((x, y) -> x / y));
        System.out.println(div);



    }
}
