package com.feign.controller;

import com.feign.service.FundsFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/funds")
public class FundsErrorController {

    @Resource
    private FundsFeign fundsFeign;

    @GetMapping("/getPurchaseListSum")
    public float getPurchaseListSum(){
        return fundsFeign.getPurchaseListSum();
    }

    @GetMapping("/getGoodsSum")
    public List<Object> getGoodsSum(){
        return fundsFeign.getGoodsSum();
    }

    @GetMapping("/getBySaleListId")
    public double getBySaleListId(Integer SaleListId){
        return fundsFeign.getBySaleListId(SaleListId);
    }

    @GetMapping("/getSaleGoodsSum")
    public List<Object> getSaleGoodsSum(){
        return fundsFeign.getSaleGoodsSum();
    }
}
