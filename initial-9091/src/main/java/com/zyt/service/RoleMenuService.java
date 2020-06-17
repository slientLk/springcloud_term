package com.zyt.service;

import com.inventory.entity.RoleMenu;
import com.zyt.dao.RoleMenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuService {

    @Autowired
    RoleMenuDAO roleMenuDAO;

    public List<RoleMenu> getRoleMenu(Integer roleId){
        return roleMenuDAO.findByRoleId(roleId);
    }
}
