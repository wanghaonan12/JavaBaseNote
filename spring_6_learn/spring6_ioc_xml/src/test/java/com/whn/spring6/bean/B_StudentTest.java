package com.whn.spring6.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Wanghn
 * @date 2024/1/8 11:21
 * 使用不同的方法 创建bean 并添加设置不同类型的元素
 */
class B_StudentTest {
    @Test
    public void createStudentOneBean(){
//        setter 创建 bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentOne", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentTwoBean(){
//                构造器创建 bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentTwo", Student.class);
        System.out.println(studentOne.toString());
    }
    @Test
    public void createStudentThreeBean(){
//        特殊属性null赋值
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentThree", Student.class);
        System.out.println(studentOne.toString());
    }
    @Test
    public void createStudentFourBean(){
//         特殊字符赋值
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentFour", Student.class);
        System.out.println(studentOne.toString());
    }
    @Test
    public void createStudentFiveBean(){
//         添加对象类型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentFive", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentSixBean(){
//         内部 Bean 添加对象类型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentSix", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentSevenBean(){
//         内部 Bean 添加对象类型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentSeven", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentEightBean(){
//         内部 Bean 添加 数组 对象类型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentEight", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentNineBean(){
//         内部 Bean 添加 Map 对象类型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Student.xml");
        Student studentOne = applicationContext.getBean("studentNine", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentTenBean(){
//         使用 Util 创建 对象类型  添加 Map 对象类型
//        使用util:list、util:map标签必须引入相应的命名空间
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("StudentUtil.xml");
        Student studentOne = applicationContext.getBean("studentTen", Student.class);
        System.out.println(studentOne.toString());
    }

    @Test
    public void createStudentElevenBean(){
//         使用 p 命名空间 创建 对象类型  添加 Map 对象类型
//        使用util:list、util:map 标签 和 p命名空间 必须引入相应的命名空间
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("StudentPNameSpace.xml");
        Student studentOne = applicationContext.getBean("studentEleven", Student.class);
        System.out.println(studentOne.toString());
    }

}