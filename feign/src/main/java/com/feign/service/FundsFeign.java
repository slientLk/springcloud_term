package com.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "funds",fallback = FundsError.class)
public interface FundsFeign {
    @GetMapping("/getPurchaseListSum")
    public float getPurchaseListSum();

    @GetMapping("/getGoodsSum")
    public List<Object> getGoodsSum();

    @GetMapping("/getBySaleListId")
    public double getBySaleListId(@RequestParam("SaleListId") Integer SaleListId);

    @GetMapping("/getSaleGoodsSum")
    public List<Object> getSaleGoodsSum();
}
