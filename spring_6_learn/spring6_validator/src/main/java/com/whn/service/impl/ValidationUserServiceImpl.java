package com.whn.service.impl;

import com.whn.po.User;
import com.whn.service.ValidationUserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Wanghn
 * @date 2024/1/11 14:17
 */
@Service
public class ValidationUserServiceImpl implements ValidationUserService {

    @Autowired
    private Validator validator;

    @Override
    public boolean validator(User user) {
        Set<ConstraintViolation<User>> sets = validator.validate(user);
        return sets.isEmpty();
    }

}
