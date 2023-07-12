package com.whn.Reflect.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WHN
 * @Date 2023/7/8 16:57
 * @description 字段信息对象
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldInfo {
    /**
     * 字段名
     */
    String fieldName;

    /**
     * 字段值
     */
    String fieldValue;
    /**
     * 注解字段名
     */
    String fieldAnnotationKey;

    /**
     * 注解字段值
     */
    String fieldAnnotationValue;
}
