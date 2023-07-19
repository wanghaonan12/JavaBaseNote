package com.whn.Thread.factory;

import com.whn.Thread.vo.ProductVo;
import com.whn.Thread.dto.WarehouseDto;

/**
 * @Author WHN
 * @Date 2023/7/18 14:46
 * @description
 * @Version 1.0
 */
public class ManufactureFactory implements Runnable{


    public WarehouseDto warehouse;

    public ManufactureFactory() {
    }

    public ManufactureFactory(WarehouseDto warehouse) {
        this.warehouse = warehouse;
    }



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            warehouse.manufactureBeer();
            warehouse.manufactureChocolate();
        }
//        manufactureChocolate();
    }
}
