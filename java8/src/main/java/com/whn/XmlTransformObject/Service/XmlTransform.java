package com.whn.XmlTransformObject.Service;

import javax.xml.bind.JAXBException;

/**
 * @Author WHN
 * @Date 2023/9/7 20:01
 * @description xml 转对象
 * @Version 1.0
 */
public interface XmlTransform {
     /**
      * xml 转对象
      * @param t 转换的对象
      * @param xml xml字符串
      * @return 转换后的对象实体
      * @param <T>
      * @throws JAXBException
      */
     <T> T xmlTransform(Class<T> t, String xml) throws JAXBException;

     /**
      * Object 转 xml
      * @param object 被转换的 object
      * @return
      * @throws JAXBException
      */
     String xmlTransform(Object object) throws JAXBException;
}
