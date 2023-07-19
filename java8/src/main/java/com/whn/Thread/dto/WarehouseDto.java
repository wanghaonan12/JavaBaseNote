package com.whn.Thread.dto;

import com.whn.Thread.vo.ProductVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WHN
 * @Date 2023/7/18 15:01
 * @description
 * @Version 1.0
 */
@Data
public class WarehouseDto {
    /**
     * 仓库啤酒数量
     */
    public  Integer beersCount=0;
    /**
     * 仓库巧克力数量
     */
    public   Integer chocolateCount=0;
    /**
     * 巧克力总产量
     */
    public Integer manufactureChocolateCount = 0;
    /**
     * 巧克力总消费量
     */
    public Integer consumptionChocolateCount = 0;
    /**
     * 啤酒总产量
     */
    public Integer manufactureBeerCount = 0;
    /**
     * 啤酒总消费量
     */
    public Integer consumptionBeerCount = 0;
    /**
     * 仓库啤酒存货
     */
    public  List<ProductVo> beers=new ArrayList<>();
    /**
     * 仓库巧克力存货
     */
    public  List<ProductVo> chocolates=new ArrayList<>();
    /**
     * 每种产品可以放的数量
     */
    public  Integer capacity = 10;


    /**
     * 生产啤酒
     */
    public synchronized void  manufactureBeer(){
        if (this.beersCount>= this.capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.beers.add(ProductVo.builder().brand("费罗娜").name("芒果味果啤").build());
        this.beersCount++;
        this.manufactureBeerCount++;
        System.out.println("啤酒总产量："+this.manufactureBeerCount+",仓库剩余："+this.beers.size()+",仓库容量："+this.beersCount+",生产了：费罗娜++++++++++++++++++++芒果味果啤+++++++++++++++++费罗娜");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
    }

    /**
     * 生产巧克力
     */
    public synchronized void  manufactureChocolate(){
        if (this.chocolateCount>=this.capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.chocolates.add(ProductVo.builder().brand("费列罗").name("草莓味巧克力").build());
        this.chocolateCount++;
        this.manufactureChocolateCount++;
        System.out.println("巧克力总产量："+this.manufactureChocolateCount+",仓库剩余："+this.chocolates.size()+",仓库容量："+this.chocolateCount+",生产了：费列罗++++++++++++++++++++草莓味巧克力+++++++++++++++++费列罗");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        notify();
    }

    /**
     * 消费啤酒
     */
    public synchronized void  consumptionBeer(){
        if (this.beersCount<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ProductVo remove = this.beers.remove(0);
        this.beersCount--;
        this.consumptionBeerCount++;
        System.out.println("啤酒总消费量："+this.consumptionBeerCount+",仓库剩余："+this.beers.size()+",仓库容量："+this.beersCount+",消费了："+remove.getBrand()+"---------------------"+remove.getName()+"-----------------"+remove.getBrand());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
    }

    /**
     * 消费巧克力
     */
    public synchronized void  consumptionChocolate(){
        if (this.chocolateCount<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ProductVo remove = this.chocolates.remove(0);
        this.chocolateCount--;
        this.consumptionChocolateCount++;
        System.out.println("巧克力总消费量："+this.consumptionChocolateCount+",仓库剩余："+this.chocolates.size()+",仓库容量："+this.chocolateCount+",消费了："+remove.getBrand()+"---------------------"+remove.getName()+"-----------------"+remove.getBrand());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
    }
}
