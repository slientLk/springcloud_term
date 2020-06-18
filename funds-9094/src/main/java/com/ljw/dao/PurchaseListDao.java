package com.ljw.dao;

import com.inventory.entity.PurchaseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PurchaseListDao extends JpaRepository<PurchaseList,Integer> {

    @Transactional
    @Query(value = "SELECT SUM(t_purchase_list.amount_paid) FROM `t_purchase_list`",nativeQuery = true)
    float getSumPaid();
}
