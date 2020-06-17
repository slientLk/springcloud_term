package cn.yqd.controller;

import cn.yqd.dao.PurchaseListGoodsDao;
import com.inventory.entity.PurchaseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @GetMapping("/test")
    public String test() {
        return "test...";
    }

    /**
     * 根据进货单号查询进货单信息
     * @param purchaseNumber
     * @return
     */
    @GetMapping("/getPurByNum/{purchaseNumber}")
    public List<PurchaseList> getPurByNum(@PathVariable String purchaseNumber) {
        return purchaseListGoodsDao.getPurchaselist(purchaseNumber);
    }

    /**
     * 添加进货单信息
     * @param purchaseList
     * @return
     */
    @PostMapping(value = "/savePurchaseList",produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer savePurchaseList(@RequestBody PurchaseList purchaseList) {
        //设置订单状态(初始值为0)
        purchaseList.setState(0);
        //设置日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        purchaseList.setPurchaseDate(sdf.format(new Date()));
        return purchaseListGoodsDao.savePurchaseList(purchaseList);
    }

    /**
     * 根据id删除进货单
     * @param purchaseListId
     * @return
     */
    @GetMapping("/deletePurchaseListById/{purchaseListId}")
    public Integer deletePurchaseListById(@PathVariable Integer purchaseListId) {
        return purchaseListGoodsDao.deletePurchaseListById(purchaseListId);
    }

    /**
     * 将订单状态设置为已处理（设置state为1）
     * @param purchaseListId
     * @return
     */
    @GetMapping("/updateState/{purchaseListId}")
    public Integer updateState(@PathVariable Integer purchaseListId) {
        return purchaseListGoodsDao.updateState(purchaseListId);
    }
}
