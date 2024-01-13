package com.whn.customIoc.service.impl;

import com.whn.customServer.dto.Ainmal;
import com.whn.customServer.dto.Cat;
import com.whn.customServer.dto.Dog;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Wanghn
 * @date 2024/1/9 15:10
 */
class CustomApplicationContextImplTest {

    @Test
    public void test() {
        CustomApplicationContextImpl customApplicationContext = new CustomApplicationContextImpl("com.whn.customServer");
        Dog dog = customApplicationContext.getBean(Dog.class);
        Cat cat = customApplicationContext.getBean(Cat.class);
        List<Ainmal> ainmalList = new ArrayList<>();
        ainmalList.add(dog);
        ainmalList.add(cat);
        for (Ainmal ainmal : ainmalList) {
            if (!Objects.isNull(ainmal)) {
                ainmal.sayHello();
            }
        }

    }
}