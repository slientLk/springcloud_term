package com.sxh.impl;

import java.util.Date;

public interface SaleDataResult {
    String getDATE();
    double getSaleTotal();
    double getPurchasingTotal();
    default String getSaleDataResult(){
        return getDATE().concat(";").concat(String.valueOf(getSaleTotal()).concat(";").concat(String.valueOf(getPurchasingTotal())).concat("     "));
    }
}
