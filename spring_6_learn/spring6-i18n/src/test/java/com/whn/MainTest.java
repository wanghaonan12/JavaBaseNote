package com.whn;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Wanghn
 * @date 2024/1/11 13:12
 */
class MainTest {

    @Test
    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //传递动态参数，使用数组形式对应{0} {1}顺序
        Object[] objs = new Object[]{"whn",new Date().toString()};

        //www.atguigu.com为资源文件的key值,
        //objs为资源文件value值所需要的参数,Local.CHINA为国际化为语言
        String str=context.getMessage("test", objs, Locale.CHINA);
        System.out.println(str);
    }

    @Test
    public void test2(){
        System.out.println(ResourceBundle.getBundle("messages",
                new Locale("en","GB")).getString("test"));
        System.out.println(ResourceBundle.getBundle("message",
                new Locale("zh","CN")).getString("test"));
    }

}