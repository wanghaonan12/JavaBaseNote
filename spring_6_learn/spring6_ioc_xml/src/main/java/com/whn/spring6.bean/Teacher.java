package com.whn.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Wanghn
 * @date 2024/1/8 13:28
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@EqualsAndHashCode
public class Teacher {

    private Integer teacherId;

    private String teacherName;

}
