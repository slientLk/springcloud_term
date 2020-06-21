package com.ljw.dao;

import com.inventory.entity.PurchaseListGoods;
import com.ljw.impl.PurchaseListGoodsResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface PurchaseListGoodsDao extends JpaRepository<PurchaseListGoods,Integer> {

    @Transactional
    @Query(value = "SELECT goods_id id,t.price*t.total sum FROM `t_purchase_list_goods` t",nativeQuery = true)
    List<PurchaseListGoodsResult> getSum();
}
