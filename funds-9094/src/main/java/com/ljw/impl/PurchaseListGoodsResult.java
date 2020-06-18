package com.ljw.impl;

public interface PurchaseListGoodsResult {
    Integer getId();
    double getSum();
    default String getPurchaseListGoodsResult(){
        return "   \n";
    }
}
