package cn.gjj.service.impl;

import cn.gjj.dao.SaleListGoodsDao;
import cn.gjj.service.SaleListGoodsService;
import cn.gjj.util.BigDecimalUtil;
import cn.gjj.util.DateUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.inventory.entity.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public String getSaleDataByDay(String sTime, String eTime) {
        JsonArray result = new JsonArray();

        try {

            // 获取所有的时间段日期
            List<String> dateList = DateUtil.getTimeSlotByDay(sTime, eTime);

            // 查询按日统计的数据
            List<SaleData> obList = saleListGoodsDao.getSaleDataByDay(sTime, eTime);

            // 按日统计的数据，如果该日期没有数据的话，则不会有显示，我们的需求是，如果该日期没有销售数据的话，也应该显示为0，所以需要进行特殊处理
            for (String date : dateList) {

                JsonObject obj = new JsonObject();

                boolean flag = false;

                for(SaleData o : obList) {

                    if(o.getDate().equals(date)){

                        obj.addProperty("date", o.getDate()); //日期

                        obj.addProperty("saleTotal", BigDecimalUtil.keepTwoDecimalPlaces(o.getSaleTotal())); //销售总额

                        obj.addProperty("purchasingTotal", BigDecimalUtil.keepTwoDecimalPlaces(o.getPurchasingTotal())); //成本总额

                        obj.addProperty("profit",BigDecimalUtil.keepTwoDecimalPlaces(o.getSaleTotal() - o.getPurchasingTotal())); //利润

                        flag = true;

                        break;

                    }

                }

                if (!flag) {// 如果没有销售数据，那么也需要设置该日的销售数据默认为0

                    obj.addProperty("date", date); //日期

                    obj.addProperty("saleTotal", 0); //销售总额

                    obj.addProperty("purchasingTotal", 0); //成本总额

                    obj.addProperty("profit",0); //利润

                }

                result.add(obj);

            }

//            logService.save(new Log(Log.SELECT_ACTION, "查询按日统计分析数据"));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result.toString();
    }

    @Override
    public String getSaleDataByMonth(String sTime, String eTime) {
        JsonArray result = new JsonArray();

        try {

            // 获取所有的时间段日期
            List<String> dateList = DateUtil.getTimeSlotByMonth(sTime, eTime);

            // 查询按日统计的数据
            List<SaleData> obList = saleListGoodsDao.getSaleDataByMonth(sTime, eTime);

            // 按日统计的数据，如果该日期没有数据的话，则不会有显示，我们的需求是，如果该日期没有销售数据的话，也应该显示为0，所以需要进行特殊处理
            for(String date : dateList){

                JsonObject obj = new JsonObject();

                boolean flag = false;

                for (SaleData o : obList) {

                    if(o.getDate().equals(date)){

                        obj.addProperty("date", o.getDate()); //日期

                        obj.addProperty("saleTotal", BigDecimalUtil.keepTwoDecimalPlaces(o.getSaleTotal())); //销售总额

                        obj.addProperty("purchasingTotal", BigDecimalUtil.keepTwoDecimalPlaces(o.getPurchasingTotal())); //成本总额

                        obj.addProperty("profit",BigDecimalUtil.keepTwoDecimalPlaces(o.getSaleTotal() - o.getPurchasingTotal())); //利润

                        flag = true;

                    }

                }

                if(!flag){// 如果没有销售数据，那么也需要设置该日的销售数据默认为0

                    obj.addProperty("date", date); //日期

                    obj.addProperty("saleTotal", 0); //销售总额

                    obj.addProperty("purchasingTotal", 0); //成本总额

                    obj.addProperty("profit",0); //利润

                }

                result.add(obj);

            }

//            logService.save(new Log(Log.SELECT_ACTION, "查询按月统计分析数据"));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result.toString();
    }
}
