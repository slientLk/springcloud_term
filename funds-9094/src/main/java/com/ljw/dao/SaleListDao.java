package com.ljw.dao;

import com.inventory.entity.SaleList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleListDao extends JpaRepository<SaleList,Integer> {

    SaleList findBySaleListId(Integer SaleListId);
}
