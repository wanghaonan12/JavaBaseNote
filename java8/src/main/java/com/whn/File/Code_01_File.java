package com.whn.File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author WHN
 * @Date 2023/7/12 14:46
 * @description file 类的基础使用
 * @Version 1.0
 */
public class Code_01_File {
    public static void main(String[] args) throws IOException {

        File file = new File("java8/src/main/java/com/whn/File/document_object_txt.txt");
//      获取一些信息属性
        System.out.println("document_object_txt:"+file.exists());
        System.out.println("文件是否可读"+file.canRead());
        System.out.println("文件的名字"+file.getName());
        System.out.println("文件的绝对位置"+file.getAbsolutePath());
        System.out.println("文件的相对位置"+file.getPath());
        System.out.println("是否是文件"+file.isFile());
        System.out.println("文件大小"+file.length());
        System.out.println("是否有抽象路径名存在 并且 允许应用程序执行文件"+file.canExecute());
        System.out.println("是否是文件"+file.isDirectory());
        System.out.println("是否隐藏"+file.isHidden());
        System.out.println("是否可写"+file.canWrite());
        System.out.println("获取上级目录"+file.getParent());
//        文件的创建与删除
        file.delete();
        if (!file.exists()) {
            System.out.println("文件不存在创建新文件...");
            file.createNewFile();
        }
//        创建文件夹
        String dir = "java8/src/main/java/com/whn/File/test1/test2";
        String dir2 = "java8/src/main/java/com/whn/File/test3/test4";
        String dir3 = "java8/src/main/java/com/whn/File/test4";
        File file1 = new File(dir);
        File file2 = new File(dir2);
        File file3 = new File(dir3);
//        如果删除的是文件夹 ，但是文件夹中有文件存在无法删除
        file3.delete();
        if (!file1.exists()) {
            System.out.println("创建文件夹...");
//            创建单个文件夹由于test1不存在，无法创建
            file1.mkdir();
//            创建多层
            file2.mkdirs();
        }

        File[] files = file3.listFiles();//获取文件加下的所有文件名
        for (File file4 : files) {
            System.out.println(file4.getName());
        }
        String[] list = file3.list();//获取文件名字
        Arrays.stream(list).forEach(System.out::println);
    }
}
