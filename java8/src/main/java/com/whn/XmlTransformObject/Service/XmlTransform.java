package com.whn.XmlTransformObject.Service;

import javax.xml.bind.JAXBException;

/**
 * @Author WHN
 * @Date 2023/9/7 20:01
 * @description xml 转对象
 * @Version 1.0
 */
public interface XmlTransform {
     <T> T xmlTransform(Class<T> t, String xml) throws JAXBException;
     String xmlTransform(Object object) throws JAXBException;
}
