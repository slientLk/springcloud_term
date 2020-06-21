package com.feign.controller;

import com.feign.service.SalesFeign;
import com.inventory.entity.SaleList;
import com.inventory.entity.SaleListGoods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesErrorController {

    @Resource
    private SalesFeign salesFeign;

    @GetMapping("/getSaleTotalByGoodsId")
    public Integer getSaleTotalByGoodsId(Integer goodsId){
        return salesFeign.getSaleTotalByGoodsId(goodsId);
    }

    @GetMapping("/saveList")
    public String saveList(SaleListGoods saleListGoods){
        return salesFeign.saveList(saleListGoods);
    }

    @GetMapping("/getSaleList")
    public List<SaleList> getSaleList(String saleNumber, Integer customerId, Integer state){
        return salesFeign.getSaleList(saleNumber,customerId,state);
    }

    @GetMapping("/getAllSaleListGoods")
    public List<SaleListGoods> getAllSaleListGoods(){
        return salesFeign.getAllSaleListGoods();
    }

    @GetMapping("/getSaleDateByDay")
    public List<Object> getSaleDateByDay(String startTime, String endTime){
        return salesFeign.getSaleDateByDay(startTime,endTime);
    }
}
