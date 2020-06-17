package com.zyt.dao;

import com.inventory.entity.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MenuDAO extends PagingAndSortingRepository<Menu,Integer> {
    Menu findByMenuId(Integer pId);
}
