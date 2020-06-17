package com.zyt.dao;

import com.inventory.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,Integer> {
    Role findByRemarks(String remarks);
}
