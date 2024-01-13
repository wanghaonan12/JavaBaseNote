package com.whn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Wanghn
 * @date 2024/1/11 19:37
 */
@Component
@ConfigurationProperties(prefix="car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String price;
}
