package com.whn.validator;


import com.whn.po.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Wanghn
 * @date 2024/1/11 13:42
 */
public class PersonValidator implements Validator {
    /**
     * 支持验证的类
     *
     * @param clazz
     * @return true表示支持
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    /**
     * 验证逻辑
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "error value < 0");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age", "error value too old");
        }
    }
}
