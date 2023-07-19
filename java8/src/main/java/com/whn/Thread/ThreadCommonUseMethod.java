package com.whn.Thread;

import com.whn.Thread.service.imp.Code_01_ThreadCreate;

/**
 * @Author WHN
 * @Date 2023/7/17 16:30
 * @description 线程常用方法
 * @Version 1.0
 */
public class ThreadCommonUseMethod {
    public static void main(String[] args) {
        // 创建新线程
        Thread thread = new Thread(() -> {
            System.out.println("线程任务开始执行");
        });

// 启动线程
        thread.start();

// 暂停当前线程一段时间
        try {
            Thread.sleep(2000); // 暂停2秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// 等待线程执行完毕
        try {
            thread.join(); // 等待线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// 中断线程
        thread.interrupt();

// 判断线程是否处于活动状态
        boolean isAlive = thread.isAlive();

// 设置线程名称
        thread.setName("MyThread");

// 获取线程名称
        String threadName = thread.getName();

// 设置线程优先级
        thread.setPriority(Thread.MAX_PRIORITY);

// 获取线程优先级
        int priority = thread.getPriority();

// 设置线程为守护线程
        thread.setDaemon(true);

// 判断线程是否为守护线程
        boolean isDaemon = thread.isDaemon();

// 让出CPU资源
        Thread.yield();

        Code_01_ThreadCreate threadCreate = new Code_01_ThreadCreate();
//        设置伴随
        threadCreate.setDaemon(true); //在主线程die之后也跟随着挂掉
        threadCreate.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("mian线程输出"+i);
        }
    }
}
