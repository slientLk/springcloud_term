package com.inventory.service;

import com.inventory.entity.PurchaseList;

import java.util.List;

public interface PurchaseListGoodsService {
    /**
     * 根据进货单号查询进货单信息
     * @param purchaseNumber
     * @return
     */
    List<PurchaseList> list(String purchaseNumber);

    /**
     * 添加进货单信息
     * @param purchaseList
     * @return
     */
    Integer savePurchaseList(PurchaseList purchaseList);

    /**
     * 根据id删除进货单
     * @param purchaseListId
     * @return
     */
    Integer deletePurchaseListById(Integer purchaseListId);

    /**
     * 将订单状态设置为已处理（设置state为1）
     * @param purchaseListId
     * @return
     */
    Integer updateState(Integer purchaseListId);
}
