package com.whn.config;

import com.whn.po.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author Wanghn
 * @date 2024/1/11 17:29
 */
//@ConditionalOnMissingBean(name = "pet")当pet这个bean不存在时添加这个配置
@ConditionalOnMissingBean(name = "pet111")
//@Import({AppConfig.class})
@Configuration(proxyBeanMethods = true)
public class TestConditionBeanConfig {
    @Resource(name = "appService")
    User user;
    @Bean("testConditionBeanConfigBean")
    public User appService() {
        // 直接引用导入的 MyConfig 配置类中的 pet
        return user;
    }
}
