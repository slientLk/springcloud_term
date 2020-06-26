package cn.yqd.service;

import com.inventory.entity.PurchaseList;

import java.util.Map;

public interface PurchaseListGoodsService {
    String count(Integer goodsTypeId, String codeOrName);
    Integer save(PurchaseList purchaseList);
    Map<String, Object> goodsList(Integer purchaseListId);
    String delete(Integer purchaseListId);
}
