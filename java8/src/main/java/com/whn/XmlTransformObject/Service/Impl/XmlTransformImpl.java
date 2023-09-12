package com.whn.XmlTransformObject.Service.Impl;

import com.whn.XmlTransformObject.Service.XmlTransform;
import com.whn.XmlTransformObject.dto.People;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @Author WHN
 * @Date 2023/9/7 20:11
 * @description
 * @Version 1.0
 */
public class XmlTransformImpl implements XmlTransform {
    @Override
    public <T> T xmlTransform(Class<T> t,String xml) throws JAXBException {
//       创建 JAXBContext 实例
        JAXBContext jaxbContext = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T unmarshal = (T)unmarshaller.unmarshal(new StringReader(xml));
        return unmarshal;
    }

    @Override
    public String xmlTransform(Object object) throws JAXBException {
        StringWriter sw = new StringWriter();
//       创建 JAXBContext 实例
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
//        Marshaller 类负责管理将 Java 内容树序列化回 XML 数据的过程。它提供了基本的编组方法：
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(object, sw);

        return sw.toString();
    }

    public static void main(String[] args) {
        People build = People.builder().sex("男").age(19).name("泽丽").admin(true).description("祖安枪手").build();
        XmlTransformImpl xmlTransform = new XmlTransformImpl();
        String s = "";
        try {
             s = xmlTransform.xmlTransform(build);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Class转Xml========================");
        System.out.println(s);

        try {
            People people = xmlTransform.xmlTransform(People.class, s);
            System.out.println("String转Class++++++++++++++++++++");
            System.out.println(people);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
