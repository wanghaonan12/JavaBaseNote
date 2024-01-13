package com.whn;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Wanghn
 * @date 2024/1/10 17:10
 * 获取类路径下的文件  src/main/resources
 * src/main/resources 这个目录下的资源文件会被复制到项目的编译输出目录（如 target/classes），成为类路径的一部分。
 * target/classes: 这是编译后的类文件和资源文件的输出目录，也是类路径之一。
 */
public class ClassPathResourceDemo {

    public static void loadAndReadUrlResource(String path) {
        // 创建一个 Resource 对象
        ClassPathResource resource = new ClassPathResource(path);

        // 检查资源是否存在
        if (!resource.exists()) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        // 获取文件名
        String filename = resource.getFilename();
        // 检查文件名是否为空
        if (StringUtils.isBlank(filename)) {
            throw new IllegalArgumentException("File name not found for resource: " + path);
        } else {
            System.out.println("File Name: " + filename);
        }

        // 获取文件描述
        String description = resource.getDescription();
        // 检查文件描述是否为空
        if (StringUtils.isBlank(description)) {
            throw new IllegalArgumentException("Description not found for resource: " + path);
        } else {
            System.out.println("Description: " + description);
        }

        // 获取文件内容
        try (InputStream in = resource.getInputStream();
             Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {

            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }

            // 输出文件内容
            System.out.println("File Content:\n" + sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read resource: " + path, e);
        }
    }




    public static void main(String[] args) throws Exception {
        loadAndReadUrlResource("test.txt");
    }
}
