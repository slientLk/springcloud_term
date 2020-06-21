package com.sxh.controller;

import com.inventory.entity.SaleList;
import com.inventory.entity.SaleListGoods;
import com.sxh.impl.SaleDataResult;
import com.sxh.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SaleListGoodsController {

    @Autowired
    SaleListGoodsService saleListGoodsService;

    @GetMapping("/getSaleTotalByGoodsId")
    public Integer getSaleTotalByGoodsId(Integer goodsId) {
        Integer result = saleListGoodsService.getSaleTotalByGoodsId(goodsId);
        return result == null ? 0 : result;
    }

    @GetMapping("/saveList")
    public String saveList(SaleListGoods saleListGoods){
        saleListGoodsService.save(saleListGoods);
        return "保存成功";
    }

    @GetMapping("/getSaleList")
    public List<SaleList> getSaleList(String saleNumber, Integer customerId, Integer state){
        return saleListGoodsService.getSaleList(saleNumber,customerId,state);
    }

    @GetMapping("/getAllSaleListGoods")
    public List<SaleListGoods> getAllSaleListGoods(){
        return saleListGoodsService.getAllSaleListGoods();
    }

    @GetMapping("/getSaleDateByDay")
    public List<SaleDataResult> getSaleDateByDay(String startTime, String endTime) {
        return saleListGoodsService.getSaleDateByDay(startTime,endTime);
    }
}
