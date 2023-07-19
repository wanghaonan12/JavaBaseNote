package com.whn.Thread;

/**
 * @Author WHN
 * @Date 2023/7/17 16:20
 * @description 线程生命周期
 * @Version 1.0
 */
public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        // 创建新线程
        Thread thread = new Thread(() -> {
            // 线程任务代码
            System.out.println("线程任务开始执行");
            try {
                Thread.sleep(2000); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程任务执行完毕");
        });

        System.out.println("1线程状态：" + thread.getState()); // 打印线程状态
        System.out.println("线程启动start");
        // 启动线程
        thread.start();

        System.out.println("2线程状态：" + thread.getState()); // 打印线程状态

        try {
            System.out.println("线程进入睡眠1秒");
            Thread.sleep(1000); // 等待1秒，确保线程进入运行状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("3线程状态：" + thread.getState()); // 打印线程状态

        try {
            thread.join(); // 等待线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("4线程状态：" + thread.getState()); // 打印线程状态
    }
}

