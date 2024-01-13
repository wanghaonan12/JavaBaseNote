package com.whn.spring6.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Wanghn
 * @date 2024/1/8 14:36
 * 使用 context 创建 bean 并连接数据库
 */
public class C_DatabaseConnect {
    @Test
    public void DatabaseConnectTest() throws SQLException {
//        通过配置文件创建 Bean 并连接数据库
            ApplicationContext ac = new ClassPathXmlApplicationContext("JDBCBeanContext .xml");
            DataSource dataSource = ac.getBean(DataSource.class);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
    }
}
