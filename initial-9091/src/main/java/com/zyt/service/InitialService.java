package com.zyt.service;

import com.inventory.entity.*;
import com.zyt.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitialService {

    @Autowired
    DamageListGoodsDAO damageListGoodsDAO;

    @Autowired
    LogDAO logDAO;

    @Autowired
    MenuDAO menuDAO;

    @Autowired
    RoleMenuDAO roleMenuDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    UserDAO userDAO;

    public Integer getDamage(){
        return damageListGoodsDAO.getDamageCount();
    }

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    public List<Log> findAllLogs(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<Log> logs = logDAO.findAll(pageable);
        return logs.getContent();
    }

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    public Menu getMenu(Integer pid){
        return menuDAO.findByMenuId(pid);
    }

    public List<RoleMenu> getRoleMenu(Integer roleId){
        return roleMenuDAO.findByRoleId(roleId);
    }

    public Role getRoleByRemarks(String remark){
        return roleDAO.findByRemarks(remark);
    }

    public User getByUserNameAndPassword(String userName,String password){
        return userDAO.findByUserNameAndPassword(userName,password);
    }
}
