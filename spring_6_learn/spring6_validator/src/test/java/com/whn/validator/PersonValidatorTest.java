package com.whn.validator;

import com.whn.config.ValidationConfig;
import com.whn.po.Person;
import com.whn.po.User;
import com.whn.service.SpringframeworkValidatorUserService;
import com.whn.service.ValidationUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @author Wanghn
 * @date 2024/1/11 13:58
 */
@SpringJUnitConfig(ValidationConfig.class)
class PersonValidatorTest {

    @Autowired
    private ValidationUserService validationUserService;

    @Autowired
    private SpringframeworkValidatorUserService springframeworkValidatorUserService;
    @Test
    void test1(){
        //创建person对象
        Person person = new Person();
        person.setName("lucy");
        person.setAge(-1);
        // 创建Person对应的DataBinder
        DataBinder binder = new DataBinder(person);
        // 设置校验
        binder.setValidator(new PersonValidator());
        // 由于Person对象中的属性为空，所以校验不通过
        binder.validate();
        //输出结果
        BindingResult results = binder.getBindingResult();
        System.out.println(results.getAllErrors());
    }


    @Test
    public void testMyService1() {

        User user = new User();
        user.setAge(20);
        user.setName("lucy");
        boolean validator = validationUserService.validator(user);
        System.out.println(validator);
    }

    @Test
    public void test2() {
        User user = new User();
        user.setName("lucy");
        user.setAge(1);
        user.setPhone("13814414414");
        boolean validator = springframeworkValidatorUserService.validaPersonByValidator(user);
        System.out.println(validator);
    }

    @Test
    public void test3() {
        User user = new User();
        user.setName("lucy");
        user.setAge(10);
        user.setPhone("13814414414");
        System.out.println(springframeworkValidatorUserService.testParams(user));
    }

    @Test
    public void test4() {
        User user = new User();
        user.setName("l ucy");
        user.setAge(10);
        user.setPhone("13814414414");
        System.out.println(springframeworkValidatorUserService.testParams(user));
    }
}