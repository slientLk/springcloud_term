package com.feign.service;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FundsError implements FundsFeign{
    @Override
    public float getPurchaseListSum() {
        return 0;
    }

    @Override
    public List<Object> getGoodsSum() {
        return null;
    }

    @Override
    public double getBySaleListId(Integer SaleListId) {
        return 0;
    }

    @Override
    public List<Object> getSaleGoodsSum() {
        return null;
    }
}
