package com.whn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Wanghn
 * @date 2024/1/11 10:17
 */
@Configuration
//@ComponentScan({"com.whn.service", "com.whn.handler"})
@ComponentScan("com.whn")
//@EnableAspectJAutoProxy(proxyTargetClass = true) 开启切面
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Config {
}
