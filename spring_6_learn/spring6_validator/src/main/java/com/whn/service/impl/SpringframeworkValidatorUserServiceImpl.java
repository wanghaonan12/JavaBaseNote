package com.whn.service.impl;

import com.whn.po.User;
import com.whn.service.SpringframeworkValidatorUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

/**
 * @author Wanghn
 * @date 2024/1/11 14:17
 */
@Validated
@Service
public class SpringframeworkValidatorUserServiceImpl implements SpringframeworkValidatorUserService {

    @Autowired
    private Validator validator;

    @Override
    public boolean validaPersonByValidator(User user) {
        BindException bindException = new BindException(user, user.getClass().getName());
        validator.validate(user, bindException);
        return bindException.hasErrors();
    }

    @Override
    public String testParams(@NotNull @Valid User user) {
        return user.toString();
    }
}
