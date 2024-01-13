package com.whn.customIoc.service.impl;

import com.whn.customIoc.annotation.CustomBean;
import com.whn.customIoc.service.CustomApplicationContext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wanghn
 * @date 2024/1/9 14:40
 */
public class CustomApplicationContextImpl implements CustomApplicationContext {
    private static Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath = "";

    @Override
    public <T> T getBean(Class<T> clazz) {
        return (T) beanFactory.getOrDefault(clazz, null);
    }

    /**
     * 获取类扫描到的 Dog Bean
     *
     * @param packageName 需要扫描的包
     */
    public CustomApplicationContextImpl(String packageName) {
        try {
            String packageDirName = packageName.replaceAll("\\.", "/");
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                rootPath = filePath.substring(0, filePath.length() - packageDirName.length());
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadBean(File file) {
        // 加载bean的方法
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                // 如果文件为空，则返回
                return;
            }
            for (File child : files) {
                if (child.isDirectory()) {
                    // 如果是目录，则递归调用loadBean方法
                    loadBean(child);
                } else {
                    // 判断文件是否为class文件
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    if (pathWithClass.endsWith(".class")) {
                        String fullName = pathWithClass.replaceAll("\\\\", "\\.").replace(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);
                            // 判断类是否为接口，并且是否被CustomBean注解标记
                            if (!aClass.isInterface() && aClass.isAnnotationPresent(CustomBean.class)) {
                                Object instance = aClass.getConstructor(new Class[]{}).newInstance();
                                if (aClass.getInterfaces().length > 0) {
                                    // 如果有接口，则把接口作为key，实例对象作为value，存入beanFactory
                                    System.out.println("正在加载【" + aClass.getInterfaces()[0] + "】,实例对象是：" + instance.getClass().getName());
                                    beanFactory.put(aClass.getInterfaces()[0], instance);
                                } else {
                                    // 没有接口，则把class作为key，实例对象作为value，存入beanFactory
                                    System.out.println("正在加载【" + aClass.getName() + "】,实例对象是：" + instance.getClass().getName());
                                    beanFactory.put(aClass, instance);
                                }
                            }
                        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException |
                                 IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

}
