package com.whn.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wanghn
 * @date 2024/1/9 9:54
 */
@AllArgsConstructor
@Getter
@Slf4j
public class User {
    private String u_id;

    private String u_name;

    private int u_age;

    public User() {
       log.info("生命周期：1、创建对象");
    }

    public void setU_id(String u_id) {
        log.info("生命周期：2、设置 属性");
        this.u_id = u_id;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }

    public void initMethod(){
        log.info("生命周期：3、初始化");
    }

    public void destroyMethod(){
       log.info("生命周期：5、销毁");
    }




}
