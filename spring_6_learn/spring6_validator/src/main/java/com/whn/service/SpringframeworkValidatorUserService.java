package com.whn.service;

import com.whn.po.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * @author Wanghn
 * @date 2024/1/11 14:17
 */
public interface SpringframeworkValidatorUserService {
    public boolean validaPersonByValidator(User user);

    public String testParams(@NotNull @Valid User user);
}
