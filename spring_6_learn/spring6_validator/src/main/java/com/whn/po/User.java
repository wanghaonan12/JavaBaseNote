package com.whn.po;

import com.whn.annonation.CanNotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wanghn
 * @date 2024/1/11 14:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 使用 @NotNull 限制必须不为null
     * 使用 @NotEmpty 只作用于字符串类型，字符串不为空，并且长度不为0
     * 使用 @NotBlank 只作用于字符串类型，字符串不为空，并且trim()后不为空串
     * 使用 @DecimalMax(value) 限制必须为一个不大于指定值的数字
     * 使用 @DecimalMin(value) 限制必须为一个不小于指定值的数字
     * 使用 @Max(value) 限制必须为一个不大于指定值的数字
     * 使用 @Min(value) 限制必须为一个不小于指定值的数字
     * 使用 @Pattern(value) 限制必须符合指定的正则表达式
     * 使用 @Size(max,min) 限制字符长度必须在min到max之间
     * 使用 @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
     */

    @NotNull
    @CanNotBlank
    private String name;

    @Min(0)
    @Max(120)
    private int age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

}
