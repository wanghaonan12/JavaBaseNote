package com.whn.Lambda.service;

import java.util.List;

/**
 * @Author WHN
 * @Date 2023/6/30 11:26
 * @description
 * @Version 1.0
 */
public interface LambdaService <T>{
    /**
     *  lambda传统方法筛选操作接口
     * @param list list
     * @return List<T>
     */
    List<T>  doSelect(List<T> list);

}
