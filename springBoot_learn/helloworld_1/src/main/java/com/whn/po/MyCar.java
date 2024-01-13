package com.whn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Wanghn
 * @date 2024/1/11 19:44
 */
@ConfigurationProperties(prefix="mycar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCar {
    private String brand;
    private String price;
}
