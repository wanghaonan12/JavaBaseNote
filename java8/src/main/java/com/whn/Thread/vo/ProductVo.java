package com.whn.Thread.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WHN
 * @Date 2023/7/18 14:44
 * @description 商品类
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo {
    /**
     * 品牌
     */
    String brand;

    /**
     * 名字
     */
    String name;
}
