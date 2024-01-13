package com.whn.config;

import com.whn.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 15:44
 * @Description: 配置拦截
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/login","/src/**","/css/**","/fonts/**","/images/**","/js/**","/actuator/**"); //放行的请求
    }

//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) {
//        return http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests.anyRequest().permitAll())
//                .csrf().disable().build();
//    }
}