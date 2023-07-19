package com.whn.Thread.service.imp;

/**
 * @Author WHN
 * @Date 2023/7/17 15:13
 * @description 模拟购票线程
 * @Version 1.0
 */
public class ThreadSecure_02_Impl extends Thread {
    public ThreadSecure_02_Impl(String name) {
        super(name);
    }

    static Integer ticket = 10000;

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
//        上锁
            synchronized (ThreadSecure_02_Impl.class) {
                if (ticket > 0) {
                    System.out.println("用户在：" + this.getName() + "购买第" + ticket-- + "张去北京的车票！");
                }
            }
        }
    }
}
