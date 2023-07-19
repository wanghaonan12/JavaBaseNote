package com.whn.Thread.service.imp;


/**
 * @Author WHN
 * @Date 2023/7/17 15:13
 * @description
 * @Version 1.0
 */
public class Code_01_ThreadCreate extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程："+this.getName()+"执行第"+(i+1)+"次！");
        }
    }
}
