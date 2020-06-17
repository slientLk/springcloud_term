package com.zyt.dao;

import com.inventory.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleMenuDAO extends JpaRepository<RoleMenu,Integer> {
    List<RoleMenu> findByRoleId(Integer roleId);
}
