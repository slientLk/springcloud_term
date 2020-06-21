package com.ljw.service;

import com.ljw.dao.PurchaseListDao;
import com.ljw.dao.PurchaseListGoodsDao;
import com.ljw.dao.SaleListDao;
import com.ljw.dao.SaleListGoodsDao;
import com.ljw.impl.PurchaseListGoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FundsService {

    @Autowired
    PurchaseListDao purchaseListDao;

    @Autowired
    PurchaseListGoodsDao purchaseListGoodsDao;

    @Autowired
    SaleListDao saleListDao;

    @Autowired
    SaleListGoodsDao saleListGoodsDao;

    public float getPurchaseListSum(){
        return purchaseListDao.getSumPaid();
    }

    public List<PurchaseListGoodsResult> getGoodsSum(){
        return purchaseListGoodsDao.getSum();
    }

    public double getBySaleListId(Integer SaleListId){
        return saleListDao.findBySaleListId(SaleListId).getAmountPaid();
    }

    public List<PurchaseListGoodsResult> getSaleGoodsSum(){
        return saleListGoodsDao.getSaleGoodsSum();
    }
}
