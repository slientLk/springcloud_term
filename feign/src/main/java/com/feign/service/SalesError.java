package com.feign.service;


import com.inventory.entity.SaleList;
import com.inventory.entity.SaleListGoods;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesError implements SalesFeign{
    @Override
    public Integer getSaleTotalByGoodsId(Integer goodsId) {
        return null;
    }

    @Override
    public String saveList(SaleListGoods saleListGoods) {
        return null;
    }

    @Override
    public List<SaleList> getSaleList(String saleNumber, Integer customerId, Integer state) {
        return null;
    }

    @Override
    public List<SaleListGoods> getAllSaleListGoods() {
        return null;
    }

    @Override
    public List<Object> getSaleDateByDay(String startTime, String endTime) {
        return null;
    }
}
