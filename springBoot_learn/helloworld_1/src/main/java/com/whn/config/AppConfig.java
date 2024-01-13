package com.whn.config;

import com.whn.po.Pet;
import com.whn.po.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Wanghn
 * @date 2024/1/11 17:15
 */
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类 == 配置文件
@Import(MyConfig.class)
// 导入配置MyConfig中的bean对象,无需显示注入MyConfig类中使用的Bean对象
public class AppConfig {

    @Bean("appService")
    public User appService(Pet pet) {
        // 直接引用导入的 MyConfig 配置类中的 pet
        return new User(pet);
    }
}
