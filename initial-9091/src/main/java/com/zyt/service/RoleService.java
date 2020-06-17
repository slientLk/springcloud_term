package com.zyt.service;

import com.inventory.entity.Role;
import com.zyt.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role getRoleByRemarks(String remark){
        return roleDAO.findByRemarks(remark);
    }
}
