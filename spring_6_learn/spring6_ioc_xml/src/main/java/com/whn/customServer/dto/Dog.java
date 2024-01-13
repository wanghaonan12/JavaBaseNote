package com.whn.customServer.dto;

import com.whn.customIoc.annotation.CustomBean;

/**
 * @author Wanghn
 * @date 2024/1/9 14:44
 * 自定义实体类型 Dog 测试 自定义IOC注入管理
 */

@CustomBean
public class Dog extends Ainmal
{
    @Override
    public void sayHello(){
        System.out.println(
                "汪汪汪"
        );

    }
}
