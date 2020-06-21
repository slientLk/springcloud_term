package com.feign.service;

import com.inventory.entity.SaleList;
import com.inventory.entity.SaleListGoods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "sales",fallback = SalesError.class)
public interface SalesFeign {

    @GetMapping("/getSaleTotalByGoodsId")
    public Integer getSaleTotalByGoodsId(@RequestParam("goodsId") Integer goodsId);

    @GetMapping("/saveList")
    public String saveList(@SpringQueryMap SaleListGoods saleListGoods);

    @GetMapping("/getSaleList")
    public List<SaleList> getSaleList(@RequestParam("saleNumber") String saleNumber,@RequestParam("customerId") Integer customerId,@RequestParam("state") Integer state);

    @GetMapping("/getAllSaleListGoods")
    public List<SaleListGoods> getAllSaleListGoods();

    @GetMapping("/getSaleDateByDay")
    public List<Object> getSaleDateByDay(@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime);
}
