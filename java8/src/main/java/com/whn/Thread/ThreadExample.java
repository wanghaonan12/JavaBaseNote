package com.whn.Thread;

import com.whn.Thread.dto.WarehouseDto;
import com.whn.Thread.factory.ConsumerFactory;
import com.whn.Thread.factory.ManufactureFactory;

/**
 * @Author WHN
 * @Date 2023/7/18 15:10
 * @description 线程案例
 * @Version 1.0
 */
public class ThreadExample {
    public static void main(String[] args) {
        WarehouseDto warehouseDto = new WarehouseDto();
        ConsumerFactory consumerFactory = new ConsumerFactory(warehouseDto);
        ManufactureFactory manufactureFactory = new ManufactureFactory(warehouseDto);
        Thread thread = new Thread(consumerFactory);
        Thread thread1 = new Thread(manufactureFactory);
        thread1.start();
        thread.start();
    }
}
