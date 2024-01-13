package com.whn.config;

import com.whn.po.MyCar;
import com.whn.po.Pet;
import com.whn.po.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wanghn
 * @date 2024/1/11 16:46
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 */
@Configuration(proxyBeanMethods = true)
//@EnableConfigurationProperties({MyCar.class}) 启动这个配置类的时候会自动加入MyCar类的导入并加入到容器中
@EnableConfigurationProperties({MyCar.class})
public class MyConfig {
    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean("user01") //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        zhangsan.setU_pet(tomcatPet());
        return zhangsan;
    }

    @Bean("pet")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
