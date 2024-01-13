package com.whn;

import org.springframework.core.io.UrlResource;

/**
 * @author Wanghn
 * @date 2024/1/10 16:57
 * Resource的一个实现类，用来访问网络资源，它支持URL的绝对路径。
 * http:------该前缀用于访问基于HTTP协议的网络资源。
 * ftp:------该前缀用于访问基于FTP协议的网络资源
 * file: ------该前缀用于从文件系统中读取资源
 */
public class UrlResourceDemo {
    public static void loadAndReadUrlResource(String path){
        // 创建一个 Resource 对象
        UrlResource url = null;
        try {
            url = new UrlResource(path);
            // 获取资源名
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            // 获取资源描述
            System.out.println(url.getDescription());
            System.out.println(url.getFile().getAbsolutePath());
            //获取资源内容
            System.out.println(url.exists());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //访问网络资源
//        loadAndReadUrlResource("http://www.baidu.com");
        //2 访问文件系统资源<在项目目录下>
        loadAndReadUrlResource("file:temp.txt");
    }
}
