package com.whn.Lambda.service.Impl;

import com.whn.Lambda.service.LambdaService;
import com.whn.Lambda.dto.People;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WHN
 * @Date 2023/6/30 11:31
 * @description
 * @Version 1.0
 */
public class LambdaFilterAge implements LambdaService<People> {
    @Override
    public List<People> doSelect(List<People> list) {
        List<People> result = new ArrayList<>();
        for (People people : list) {
            if (people.getAge()>18) result.add(people);
        }
        return result;
    }
}
