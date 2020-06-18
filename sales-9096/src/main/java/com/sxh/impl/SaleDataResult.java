package com.sxh.impl;

import java.util.Date;

public interface SaleDataResult {
    String getDATE();
    double getSaleTotal();
    double getPurchasingTotal();
    default String getSaleDataResult(){
        return "          \n";
    }
}
