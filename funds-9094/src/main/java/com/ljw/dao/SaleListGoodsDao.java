package com.ljw.dao;

import com.inventory.entity.SaleListGoods;
import com.ljw.impl.PurchaseListGoodsResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface SaleListGoodsDao extends JpaRepository<SaleListGoods,Integer> {

    @Transactional
    @Query(value = "SELECT sale_list_goods_id id,price*total sum FROM t_sale_list_goods",nativeQuery = true)
    List<PurchaseListGoodsResult> getSaleGoodsSum();
}
