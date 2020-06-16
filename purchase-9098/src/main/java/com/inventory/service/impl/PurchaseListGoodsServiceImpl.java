package com.inventory.service.impl;

import com.inventory.dao.PurchaseListGoodsDao;
import com.inventory.entity.PurchaseList;
import com.inventory.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {
    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @Override
    public List<PurchaseList> list(String purchaseNumber) {

        return purchaseListGoodsDao.getPurchaselist(purchaseNumber);
    }

    @Override
    public Integer savePurchaseList(PurchaseList purchaseList) {
        return purchaseListGoodsDao.savePurchaseList(purchaseList);
    }

    @Override
    public Integer deletePurchaseListById(Integer purchaseListId) {
        return purchaseListGoodsDao.deletePurchaseListById(purchaseListId);
    }

    @Override
    public Integer updateState(Integer purchaseListId) {
        return purchaseListGoodsDao.updateState(purchaseListId);
    }
}
