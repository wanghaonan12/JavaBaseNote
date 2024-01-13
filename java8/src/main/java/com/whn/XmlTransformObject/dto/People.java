package com.whn.XmlTransformObject.dto;

import com.whn.XmlTransformObject.Utils.AdminAdapter;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @Author WHN
 * @Date 2023/9/7 19:38
 * @description 转换演示类
 * @Version 1.0
 */
@Data
@Builder
@XmlRootElement(name = "People")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class People {
    /**
     * 名字
     */
    @XmlElement(name = "姓名")
    String name;

    /**
     * 描述
     */
    String description;

    /**
     * 年龄
     */
    @XmlElement(name = "年龄")
    Integer age;

    /**
     * 是否是主管
     */
    @XmlElement(name = "是否是主管")
    @XmlJavaTypeAdapter(AdminAdapter.class)
    Boolean admin;

    /**
     * 性别
     */
    @XmlElement
    String sex;
}
