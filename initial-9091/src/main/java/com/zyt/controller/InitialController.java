package com.zyt.controller;


import com.inventory.entity.Log;
import com.inventory.entity.Menu;
import com.inventory.entity.Role;
import com.inventory.entity.RoleMenu;
import com.zyt.service.LogService;
import com.zyt.service.MenuService;
import com.zyt.service.RoleMenuService;
import com.zyt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Init")
@ResponseBody
public class InitialController {

    @Autowired
    MenuService menuService;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleMenuService roleMenuService;

    @Autowired
    LogService logService;

    @RequestMapping("/getBasicMenu")
    public List<String> getMenu(){
        List<String> menuList;
        menuList = new ArrayList<String>();
        menuList.add("登陆");
        menuList.add("后台管理");
        menuList.add("注销");
        return menuList;
    }

    @RequestMapping("/getMenuByRemarks")
    public List<Menu> getMenuList(String remarks){
        Role role = roleService.getRoleByRemarks(remarks);
        List<RoleMenu> roleMenuList = roleMenuService.getRoleMenu(role.getRoleId());
        List<Menu> menus = new ArrayList<>();
        for (RoleMenu roleMenu : roleMenuList){
            menus.add(menuService.getMenu(roleMenu.getMenuId()));
        }
        return menus;
    }

    @RequestMapping("/getLogs")
    public List<Log> getLogs(int page,int size){
        return logService.findAllLogs(page,size);
    }
}
