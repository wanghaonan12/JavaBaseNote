package com.whn;

import org.springframework.core.io.FileSystemResource;

import java.io.InputStream;

/**
 * @author Wanghn
 * @date 2024/1/10 17:24
 * 将尝试从文件系统中加载位于
 */
public class FileSystemResourceDemo {
    public static void loadAndReadUrlResource(String path) throws Exception{
        //相对路径
        FileSystemResource resource = new FileSystemResource(path);
        // 获取文件名
        System.out.println("resource.getFileName = " + resource.getFilename());
        // 获取文件描述
        System.out.println("resource.getDescription = "+ resource.getDescription());
        //获取文件内容
        InputStream in = resource.getInputStream();
        byte[] b = new byte[1024];
        while(in.read(b)!=-1) {
            System.out.println(new String(b));
        }
    }

    public static void main(String[] args) throws Exception {
//        将尝试从文件系统中加载位于 spring6_resources\src\main\resources\test.txt
        loadAndReadUrlResource("spring6_resources\\src\\main\\resources\\test.txt");
//        绝对路径
        loadAndReadUrlResource("D:\\DeskTop\\document\\demo\\myself\\spring_6_learn\\spring6_resources\\src\\main\\resources\\test.txt");
    }
}
