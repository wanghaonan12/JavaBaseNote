package com.whn.demo;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author Wanghn
 * @date 2024/1/11 19:00
 * 获取配置文件中的参数封装到类里面
 */
public class GetProperties {
    public static void main(String[] args) throws IOException {
//        类路径下的文件
        ClassPathResource classPathResource = new ClassPathResource("a.properties");
        File file = classPathResource.getFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties pps = new Properties();
//        文件系统路径下的文件
        pps.load(new FileInputStream("a.properties"));
        Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + ":" + strValue);
            //封装到JavaBean。
        }
    }
}
