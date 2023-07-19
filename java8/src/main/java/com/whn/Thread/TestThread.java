package com.whn.Thread;

import com.whn.Thread.service.imp.Code_01_ThreadCreate;
import com.whn.Thread.service.imp.Code_02_RunnableCreate;
import com.whn.Thread.service.imp.Code_03_CallableCreate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author WHN
 * @Date 2023/7/17 15:45
 * @description
 * @Version 1.0
 */
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        继承Thread类的实现方法
        Code_01_ThreadCreate threadCreate = new Code_01_ThreadCreate();
        threadCreate.start();

//        实现了runnable的实现方法
        Code_02_RunnableCreate runnableCreate = new Code_02_RunnableCreate();
        Thread thread = new Thread(runnableCreate, "thread_02222222222222222222");
        thread.start();

//       主线程的程序
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程：执行第" + (i + 1) + "次！");
        }
//        实现Callable的实现方式
        Code_03_CallableCreate callableCreate = new Code_03_CallableCreate();
        FutureTask futureTask = new FutureTask(callableCreate);
        Thread callCreateThread = new Thread(futureTask, "thread_033333333333333333333333333333333");
        callCreateThread.start();
        System.out.println( "获取的随机数：" + futureTask.get());
    }
}
