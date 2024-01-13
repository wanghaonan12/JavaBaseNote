# Xml与clas转换

**注解说明：**[javax.xml.bind.annotation （Java（TM） EE 7 规范 API） (oracle.com)](https://docs.oracle.com/javaee/7/api/javax/xml/bind/annotation/package-summary.html)
**用户指南：**[JAXB 用户指南 (javaee.github.io)](https://javaee.github.io/jaxb-v2/doc/user-guide/ch03.html#compiling-xml-schema)

## 1.添加依赖

```xml
<!--   class  xml 转换-->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
```

## 2.编写转换实现Util类

```java
public class XmlTransformUtils {
	
    /**
      * xml 转对象
      * @param t 转换的对象
      * @param xml xml字符串
      * @return 转换后的对象实体
      * @param <T>
      * @throws JAXBException
      */
    public <T> T xmlTransform(Class<T> t,String xml) throws JAXBException {
//       创建 JAXBContext 实例
        JAXBContext jaxbContext = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T unmarshal = (T)unmarshaller.unmarshal(new StringReader(xml));
        return unmarshal;
    }
	
	/**
      * Object 转 xml
      * @param object 被转换的 object
      * @return
      * @throws JAXBException
      */
    public String xmlTransform(Object object) throws JAXBException {
        StringWriter sw = new StringWriter();
//       创建 JAXBContext 实例
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
//        Marshaller 类负责管理将 Java 内容树序列化回 XML 数据的过程。它提供了基本的编组方法：
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(object, sw);

        return sw.toString();
    }
}
```

## 3.编写测试类

```java
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
```

## 4.测试

```java
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
```

**运行结果**

```
Class转Xml========================
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><People><姓名>泽丽</姓名><年龄>19</年龄><是否是主管>主管</是否是主管><sex>男</sex></People>
String转Class++++++++++++++++++++
People(name=泽丽, description=null, age=19, admin=true, sex=男)
```



