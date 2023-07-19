package com.whn.Thread.factory;

import com.whn.Thread.vo.ProductVo;
import com.whn.Thread.dto.WarehouseDto;

/**
 * @Author WHN
 * @Date 2023/7/18 14:58
 * @description
 * @Version 1.0
 */
public class ConsumerFactory implements Runnable{
    public WarehouseDto warehouse;

    public ConsumerFactory() {
    }

    public ConsumerFactory(WarehouseDto warehouse) {
        this.warehouse = warehouse;
    }



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            warehouse.consumptionBeer();
            warehouse.consumptionChocolate();

        }
//        consumptionChocolate();
    }
}
