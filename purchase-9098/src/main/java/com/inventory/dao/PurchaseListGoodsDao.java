package com.inventory.dao;


import com.inventory.entity.PurchaseList;
import com.inventory.entity.PurchaseListGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangjiangfei
 * @date 2019/8/2 9:33
 * @description
 */

public interface PurchaseListGoodsDao {

    Integer savePurchaseList(PurchaseList purchaseList);

    Integer savePurchaseListGoods(PurchaseListGoods p);

//    List<PurchaseList> getPurchaselist(@Param("purchaseNumber") String purchaseNumber,
//                                       @Param("supplierId") Integer supplierId,
//                                       @Param("state") Integer state,
//                                       @Param("sTime") String sTime,
//                                       @Param("eTime") String eTime);
    List<PurchaseList> getPurchaselist(@Param("purchaseNumber") String purchaseNumber);

    List<PurchaseListGoods> getPurchaseListGoodsByPurchaseListId(Integer purchaseListId);

    PurchaseList getPurchaseListById(Integer purchaseListId);

    Integer deletePurchaseListById(Integer purchaseListId);

    Integer deletePurchaseListGoodsByPurchaseListId(Integer purchaseListId);

    Integer updateState(Integer purchaseListId);

    List<PurchaseListGoods> getPurchaseListGoods(@Param("purchaseListId") Integer purchaseListId,
                                                 @Param("goodsTypeId") Integer goodsTypeId,
                                                 @Param("codeOrName") String codeOrName);
}