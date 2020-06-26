package cn.yqd.dao;


import com.inventory.entity.PurchaseList;
import com.inventory.entity.PurchaseListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangjiangfei
 * @date 2019/8/2 9:33
 * @description
 */
public interface PurchaseListGoodsDao {

    Integer savePurchaseList(PurchaseList purchaseList);

    List<PurchaseList> getPurchaselist(@Param("purchaseNumber") String purchaseNumber);

    List<PurchaseListGoods> getPurchaseListGoodsByPurchaseListId(Integer purchaseListId);

    Integer deletePurchaseListById(Integer purchaseListId);

    Integer deletePurchaseListGoodsByPurchaseListId(Integer purchaseListId);

    List<PurchaseListGoods> getPurchaseListGoods(@Param("purchaseListId") Integer purchaseListId,
                                                 @Param("goodsTypeId") Integer goodsTypeId,
                                                 @Param("codeOrName") String codeOrName);
}