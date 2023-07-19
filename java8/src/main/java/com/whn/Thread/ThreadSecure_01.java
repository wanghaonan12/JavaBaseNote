package com.whn.Thread;

import com.whn.Thread.service.imp.ThreadSecure_01_Impl;

/**
 * @Author WHN
 * @Date 2023/7/17 16:55
 * @description 线程安全
 * @Version 1.0
 */
public class ThreadSecure_01 {
    public static void main(String[] args) {
        ThreadSecure_01_Impl t1 = new ThreadSecure_01_Impl("窗口1");
        ThreadSecure_01_Impl t2 = new ThreadSecure_01_Impl("窗口2");
        ThreadSecure_01_Impl t3 = new ThreadSecure_01_Impl("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
