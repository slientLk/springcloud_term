package com.ljw.controller;

import com.inventory.entity.PurchaseList;
import com.inventory.entity.PurchaseListGoods;
import com.ljw.impl.PurchaseListGoodsResult;
import com.ljw.service.FundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FundsController {

    @Autowired
    FundsService fundsService;

    @GetMapping("/getPurchaseListSum")
    public float getPurchaseListSum(){
        return fundsService.getPurchaseListSum();
    }

    @GetMapping("/getGoodsSum")
    public List<PurchaseListGoodsResult> getGoodsSum(){
        return fundsService.getGoodsSum();
    }

    @GetMapping("/getBySaleListId")
    public double getBySaleListId(Integer SaleListId){
        return fundsService.getBySaleListId(SaleListId);
    }

    @GetMapping("/getSaleGoodsSum")
    public List<PurchaseListGoodsResult> getSaleGoodsSum(){
        return fundsService.getSaleGoodsSum();
    }
}
