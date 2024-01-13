package com.whn;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Wanghn
 * @date 2024/1/11 11:43
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(ResourceBundle.getBundle("messages",
                new Locale("en","GB")).getString("test"));

        System.out.println(ResourceBundle.getBundle("messages",
                new Locale("zh","CN")).getString("test"));
    }
}