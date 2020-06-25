package cn.gjj.service;

public interface SaleListGoodsService {

    String getSaleDataByDay(String sTime, String eTime);

    String getSaleDataByMonth(String sTime, String eTime);

}
