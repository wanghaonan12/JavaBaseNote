package com.whn.Thread;

import com.whn.Thread.service.imp.ThreadSecure_03_Impl;

/**
 * @Author WHN
 * @Date 2023/7/17 16:55
 * @description 线程安全
 * @Version 1.0
 */
public class ThreadSecure_03 {
    public static void main(String[] args) {
        ThreadSecure_03_Impl t1 = new ThreadSecure_03_Impl();
        Thread thread1 = new Thread(t1,"窗口1");
        Thread thread2 = new Thread(t1,"窗口2");
        Thread thread3 = new Thread(t1,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
