package com.whn.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Wanghn
 * @date 2024/1/9 10:08
 * Car 自定义后置处理器
 */

@AllArgsConstructor
@Getter
@Slf4j
public class MyProcessor implements BeanPostProcessor {
//    private String c_name;
//
//    private String c_brand;
//
//    private String c_color;
//
//    public MyProcessor() {
//        log.info("生命周期：1、创建对象");
//    }
//
//    public void setC_name(String c_name) {
//        log.info("生命周期：2、设置属性");
//        this.c_name = c_name;
//    }
//
//    public void setC_brand(String c_brand) {
//        this.c_brand = c_brand;
//    }
//
//    public void setC_color(String c_color) {
//        this.c_color = c_color;
//    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("生命周期：※※※、自定义前置处理器");
        return bean;
    }

//    public void initMethod(){
//        log.info("生命周期：4、初始化");
//    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("生命周期：※※※、自定义后置处理器");
        return bean;
    }
//
//    public void destroyMethod(){
//        log.info("生命周期：7、销毁");
//    }

}
