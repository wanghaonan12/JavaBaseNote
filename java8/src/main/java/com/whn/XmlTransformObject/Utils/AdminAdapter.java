package com.whn.XmlTransformObject.Utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @Author WHN
 * @Date 2023/9/7 19:47
 * @description User admin 字段映射
 * @Version 1.0
 * XmlAdapter<String,Boolean> 其中第一个泛型String是xml 转 Object 读取到得值, 第二个泛型 Boolean 是 Object 转成 Xml 时读取的值
 * 就是第二个泛型是转换的类型,第一个是转换后的类型
 */
public class AdminAdapter extends XmlAdapter<String,Boolean> {
    final String ADMIN = "admin";
    final String SHOW_ADMIN = "主管";
    final String SHOW_USER = "员工";

    /**
     * unmarshal方法会在 xml 转 Object 的时候调用
     * @param s 读取xml的值
     * @return 转换后的值
     * @throws Exception 异常
     */
    @Override
    public Boolean unmarshal(String s) throws Exception {
        return SHOW_ADMIN.equals(s);
    }

    /**
     * marshal方法会在 Object 转 xml 的时候调用
     * @param aBoolean 读取 Object 的值
     * @return 转换后的值
     * @throws Exception 异常
     */
    @Override
    public String marshal(Boolean aBoolean) throws Exception {
        return aBoolean ? SHOW_ADMIN : SHOW_USER;
    }
}
