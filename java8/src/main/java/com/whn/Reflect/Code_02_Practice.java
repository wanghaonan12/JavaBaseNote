package com.whn.Reflect;

import com.whn.Reflect.Annotation.MyAnnotation;
import com.whn.Reflect.dto.Dog;
import com.whn.Reflect.dto.FieldInfo;
import com.whn.Reflect.dto.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author WHN
 * @Date 2023/7/7 16:56
 * @description 反射练习
 * @Version 1.0
 */
public class Code_02_Practice {
    /**
     * 现在我们需要实现一个功能要求如下：
     * 1：一个静态方法
     * 2：随意传进去一个对象，不论是集合还是单个对象
     * 3：解析出对象的属性
     * 4：将拥有自定注解属性放在一个 map 集合中，如果传入的是对象集合并根据注解的 value为 2 的字段进行排序
     */

    public static List<List<FieldInfo>> practiceUtils(Class tClass, Object object) {

        List<List<FieldInfo>> result = new ArrayList<>();
        //判断是否是集合类型
        boolean isCollection = object instanceof Collection;
//      判断是对象是否是集合类型
        if (isCollection) {
//            强转成集合进行操作
            try {
                Collection<?> collection = (Collection<?>) object;
                Iterator<?> iterator = collection.iterator();
//                循环比哪里集合
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    List<FieldInfo> fieldAnno = new ArrayList<>();
                    getFieldInfo(tClass, next, fieldAnno);
                    if (!fieldAnno.isEmpty()) {
                        result.add(fieldAnno);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {

            List<FieldInfo> fieldAnno = new ArrayList<>();
            try {
                getFieldInfo(tClass, object, fieldAnno);
                result.add(fieldAnno);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
//        根据value 为2的字段进行排序
        List<List<FieldInfo>> collect = result.stream().sorted((fieldInfoList,fieldInfoList2) -> {
            Integer orderField1=0;
            Integer orderField2=0;
            for (FieldInfo fieldInfo : fieldInfoList) {
                if (fieldInfo.getFieldAnnotationValue().equals("2")) {
                    orderField1=Integer.valueOf(fieldInfo.getFieldValue());
                }
            }
            for (FieldInfo fieldInfo : fieldInfoList2) {
                if (fieldInfo.getFieldAnnotationValue().equals("2")) {
                    orderField2=Integer.valueOf(fieldInfo.getFieldValue());
                }
            }
            return Integer.compare(orderField1,orderField2);
        }).collect(Collectors.toList());
//        返回排序结果
        return collect;
    }

    /**
     *
     *
     * @param tClass 解析对象类的class
     * @param object 需要解析的对象
     * @param fieldAnno 最终存放的字段信息结果
     * @throws IllegalAccessException
     */
    public static void getFieldInfo(Class tClass, Object object, List<FieldInfo> fieldAnno) throws IllegalAccessException {
        //       获取class的所有字段
        Field[] fields = tClass.getDeclaredFields();
        for (Field field : fields) {
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
//           如果该字段拥有自定义注解并且 value = 2
            if (null != annotation) {
                FieldInfo fieldInfo = new FieldInfo();
                // 获取字段的值
                field.setAccessible(true);
                Map<String, Object> map = new HashMap<>();
                fieldInfo.setFieldName(field.getName());
                fieldInfo.setFieldValue(String.valueOf(field.get(object)));
                fieldInfo.setFieldAnnotationKey(annotation.key());
                fieldInfo.setFieldAnnotationValue(String.valueOf(annotation.value()));
                fieldAnno.add(fieldInfo);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().name("whn").age(18).build());
        personList.add(Person.builder().name("lxz").age(19).build());
        personList.add(Person.builder().name("wb").age(20).build());
        personList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(person -> {
            System.out.println(person);
        });
        System.out.println("");
        List<List<FieldInfo>> lists = practiceUtils(Person.class, personList);
        for (List<FieldInfo> list : lists) {
            list.forEach(System.out::print);
            System.out.println("");
        }
        System.out.println("dog class");
        List<Dog> dogList = new ArrayList<>();
        dogList.add(Dog.builder().breed("杜宾").name("大黄").age(1).build());
        dogList.add(Dog.builder().breed("雪纳瑞").name("大黑").age(3).build());
        dogList.add(Dog.builder().breed("哈士奇").name("黄豆").age(2).build());
        dogList.add(Dog.builder().breed("柯基").name("雪碧").age(1).build());
        List<List<FieldInfo>> lists1 = practiceUtils(Dog.class, dogList);
        for (List<FieldInfo> list : lists1) {
            list.forEach(System.out::print);
            System.out.println("");
        }
    }
}
