package com.sxh.impl;

public interface SaleDataResult {
    String getDATE();
    double getSaleTotal();
    double getPurchasingTotal();
    default String getSaleDataResult(){
        return "          \n";
    }
}
