package com.whn.annonation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Wanghn
 * @date 2024/1/11 15:15
 * 约束实现类
 */
public class CannotBlankValidator implements ConstraintValidator<CanNotBlank, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
//            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
//            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }
}
