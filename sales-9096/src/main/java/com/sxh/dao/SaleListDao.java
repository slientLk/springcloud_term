package com.sxh.dao;

import com.inventory.entity.SaleList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleListDao extends JpaRepository<SaleList,Integer> {

    List<SaleList> findBySaleNumberOrCustomerIdOrState(String saleNumber, Integer customerId, Integer state);
}
