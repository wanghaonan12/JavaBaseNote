package com.whn.Thread.service.imp;

/**
 * @Author WHN
 * @Date 2023/7/17 15:13
 * @description 模拟购票线程
 * @Version 1.0
 */
public class ThreadSecure_03_Impl implements Runnable {

    static Integer ticket = 10000;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
//        上锁
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println("用户在：" + Thread.currentThread().getName() + "窗口购买第" + ticket-- + "张去北京的车票！");
                }
            }
        }
    }
}
