package com.sxh.service;

import com.inventory.entity.SaleList;
import com.inventory.entity.SaleListGoods;
import com.sxh.dao.SaleListDao;
import com.sxh.dao.SaleListGoodsDao;
import com.sxh.impl.SaleDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleListGoodsService {

    @Autowired
    SaleListGoodsDao saleListGoodsDao;

    @Autowired
    SaleListDao saleListDao;

    public Integer getSaleTotalByGoodsId(Integer goodsId){
        return saleListGoodsDao.getSaleTotalByGoodsId(goodsId);
    }

    public void save(SaleListGoods saleListGoods){
        saleListGoodsDao.save(saleListGoods);
    }

    public List<SaleList> getSaleList(String saleNumber, Integer customerId, Integer state){
        return saleListDao.findBySaleNumberOrCustomerIdOrState(saleNumber,customerId,state);
    }

    public List<SaleListGoods> getAllSaleListGoods(){
        return saleListGoodsDao.findAll();
    }

    public List<SaleDataResult> getSaleDateByDay(String startTime, String endTime){
        return saleListGoodsDao.getSaleDateByDay(startTime,endTime);
    }
}
