package com.sxh.dao;

import com.inventory.entity.SaleData;
import com.inventory.entity.SaleListGoods;
import com.sxh.impl.SaleDataResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface SaleListGoodsDao extends JpaRepository<SaleListGoods,Integer> {

    @Transactional
    @Query(value = "SELECT SUM(t_sale_list_goods.goods_num) FROM t_sale_list_goods WHERE goods_id=?1",nativeQuery = true)
    Integer getSaleTotalByGoodsId(Integer goodsId);

    @Transactional
    @Query(value = "SELECT\n" +
            "            t2.sale_date AS DATE,\n" +
            "            SUM( t1.goods_num * t1.price ) AS saleTotal,\n" +
            "            SUM( t1.goods_num * t3.purchasing_price ) AS purchasingTotal\n" +
            "        FROM\n" +
            "            t_sale_list_goods t1\n" +
            "            LEFT JOIN t_sale_list t2 ON t1.sale_list_id = t2.sale_list_id\n" +
            "            LEFT JOIN t_goods t3 ON t1.goods_id = t3.goods_id\n" +
            "        WHERE\n" +
            "            t2.sale_date BETWEEN STR_TO_DATE(?1,'%Y-%m-%d') AND STR_TO_DATE(?2,'%Y-%m-%d')\n" +
            "        GROUP BY\n" +
            "            t2.sale_date",nativeQuery = true)
    List<SaleDataResult> getSaleDateByDay(String startTime, String endTime);
}
