package com.zyt.service;

import com.alibaba.fastjson.JSONObject;
import com.inventory.entity.Menu;
import com.inventory.entity.Role;
import com.inventory.entity.RoleMenu;
import com.zyt.dao.MenuDAO;
import com.zyt.dao.RoleMenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitialService {
    @Resource
    InitialApi initialApi;

    @Autowired
    MenuDAO menuDAO;

    @Autowired
    RoleMenuDAO roleMenuDAO;

    public List<Menu> getMenuList(String remarks){
        String jsonString = initialApi.getMenuByRemarks(remarks);
        System.out.println(jsonString);
        List<Menu> menus = new ArrayList<>();
        if (!jsonString.equals("serviceStop")) {
            Role role = JSONObject.parseObject(initialApi.getMenuByRemarks(remarks), Role.class);
            List<RoleMenu> roleMenuList = roleMenuDAO.findByRoleId(role.getRoleId());
            for (RoleMenu roleMenu : roleMenuList) {
                menus.add(menuDAO.findByMenuId(roleMenu.getMenuId()));
            }
        }else {
            Menu menu = new Menu();
            menu.setMenuName("该服务已停止");
            menus.add(menu);
        }
        return menus;
    }
}
