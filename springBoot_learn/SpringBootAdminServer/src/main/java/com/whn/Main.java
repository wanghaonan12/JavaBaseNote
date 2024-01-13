package com.whn;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: WangHn
 * @Date: 2024/1/13 13:28
 * @Description: ${Description}
 */
@SpringBootApplication
@EnableAdminServer// 启动可视化服务
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}