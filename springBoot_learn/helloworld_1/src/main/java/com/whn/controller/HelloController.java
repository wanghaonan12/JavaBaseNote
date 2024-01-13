package com.whn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wanghn
 * @date 2024/1/11 15:57
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/")
    public String handle01(){
        return "Hello, Spring Boot 2!";
    }
}
