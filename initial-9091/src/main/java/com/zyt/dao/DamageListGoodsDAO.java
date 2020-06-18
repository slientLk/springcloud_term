package com.zyt.dao;

import com.inventory.entity.DamageListGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DamageListGoodsDAO extends JpaRepository<DamageListGoods,Integer> {

    @Transactional
    @Query(value = "SELECT COUNT(*) Damage FROM t_damage_list_goods", nativeQuery = true)
    Integer getDamageCount();
}
