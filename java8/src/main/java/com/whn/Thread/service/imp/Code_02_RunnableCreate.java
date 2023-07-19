package com.whn.Thread.service.imp;

/**
 * @Author WHN
 * @Date 2023/7/17 15:49
 * @description
 * @Version 1.0
 */
public class Code_02_RunnableCreate implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //Thread.currentThread()作用获取当前正在执行的线程
            System.out.println("线程："+Thread.currentThread().getName()+"执行第"+(i+1)+"次！");
        }
    }
}
