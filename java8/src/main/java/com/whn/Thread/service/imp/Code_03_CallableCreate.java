package com.whn.Thread.service.imp;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Author WHN
 * @Date 2023/7/17 15:57
 * @description
 * @Version 1.0
 */
public class Code_03_CallableCreate implements Callable<Integer> {
    /*
   1.实现Callable接口，可以不带泛型，如果不带泛型，那么call方式的返回值就是Object类型
   2.如果带泛型，那么call的返回值就是泛型对应的类型
   3.从call方法看到：方法有返回值，可以跑出异常
    */
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);//返回10以内的随机数
    }
}
