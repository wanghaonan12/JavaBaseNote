package com.whn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wanghn
 * @date 2024/1/11 16:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String u_name;
    private double u_age;
    private Pet u_pet;

    public User(String u_name, double u_age) {
        this.u_name = u_name;
        this.u_age = u_age;
    }
    public User(Pet u_pet) {
        this.u_pet = u_pet;
    }
}
