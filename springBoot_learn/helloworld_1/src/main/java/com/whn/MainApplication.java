package com.whn;

import com.whn.config.MyConfig;
import com.whn.po.Car;
import com.whn.po.MyCar;
import com.whn.po.Pet;
import com.whn.po.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wanghn
 * @date 2024/1/11 15:55
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
//@SpringBootApplication 和下面三个注解的作用一样的作用
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.whn")
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 获取容器中的组件的名字
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3、从容器中获取组件

        Pet tom01 = run.getBean("pet", Pet.class);

        Pet tom02 = run.getBean("pet", Pet.class);

        System.out.println("组件："+(tom01 == tom02));


        //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);


        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("pet", Pet.class);

        System.out.println("用户的宠物："+(user01.getU_pet() == tom));

        User appService = run.getBean("appService", User.class);
        System.out.println("appService的宠物:"+appService.getU_pet());

        //测试是否有testConditionBeanConfigBean
        System.out.println(run.getBean("testConditionBeanConfigBean", User.class));
        System.out.println(run.getBean("haha", User.class));

        System.out.println(run.getBean("car", Car.class));
        System.out.println(run.getBean("mycar-com.whn.po.MyCar", MyCar.class));
    }
}