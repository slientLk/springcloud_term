package cn.yqd.service.impl;

import cn.yqd.dao.GoodsTypeDao;
import cn.yqd.dao.PurchaseListGoodsDao;
import cn.yqd.service.PurchaseListGoodsService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.inventory.entity.PurchaseList;
import com.inventory.entity.PurchaseListGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "purchase")
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Autowired
    private PurchaseListGoodsDao purchaseListGoodsDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    @CachePut(key = "#p0.purchaseListId")
    public Integer save(PurchaseList purchaseList) {
        //设置订单状态(初始值为0)
        purchaseList.setState(0);
        //设置日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        purchaseList.setPurchaseDate(sdf.format(new Date()));
        return purchaseListGoodsDao.savePurchaseList(purchaseList);
    }

    @Override
    @Cacheable(key = "#p0")
    public Map<String, Object> goodsList(Integer purchaseListId) {
        Map<String, Object> map = new HashMap<>();

        List<PurchaseListGoods> purchaseListGoodsList =
                purchaseListGoodsDao.getPurchaseListGoodsByPurchaseListId(purchaseListId);

        map.put("rows", purchaseListGoodsList);

        return map;
    }

    @Override
    @CacheEvict(key = "#p0")
    public String delete(Integer purchaseListId) {

        try {
            purchaseListGoodsDao.deletePurchaseListGoodsByPurchaseListId(purchaseListId);

            purchaseListGoodsDao.deletePurchaseListById(purchaseListId);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

    @Override
    @Cacheable(key="#root.methodName")
    public String count(Integer goodsTypeId, String codeOrName) {
        JsonArray result = new JsonArray();

        try {

            List<PurchaseList> purchaseListList = purchaseListGoodsDao.getPurchaselist(null);

            for(PurchaseList pl : purchaseListList){

                List<PurchaseListGoods> purchaseListGoodsList = purchaseListGoodsDao
                        .getPurchaseListGoods(pl.getPurchaseListId(), goodsTypeId, codeOrName);

                for(PurchaseListGoods pg : purchaseListGoodsList){

                    JsonObject obj = new JsonObject();

                    obj.addProperty("number", pl.getPurchaseNumber());

                    obj.addProperty("date", pl.getPurchaseDate());

                    obj.addProperty("supplierName", pl.getSupplierName());

                    obj.addProperty("code", pg.getGoodsCode());

                    obj.addProperty("name", pg.getGoodsName());

                    obj.addProperty("model", pg.getGoodsModel());

                    obj.addProperty("goodsType", goodsTypeDao.getGoodsTypeById(pg.getGoodsTypeId()).getGoodsTypeName());

                    obj.addProperty("unit", pg.getGoodsUnit());

                    obj.addProperty("price", pg.getPrice());

                    obj.addProperty("num", pg.getGoodsNum());

                    obj.addProperty("total", pg.getTotal());

                    result.add(obj);

                }
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

        return result.toString();
    }
}
