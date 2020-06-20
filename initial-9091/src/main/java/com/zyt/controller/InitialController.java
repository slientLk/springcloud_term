package com.zyt.controller;


import com.inventory.entity.Log;
import com.inventory.entity.Menu;
import com.inventory.entity.Role;
import com.inventory.entity.RoleMenu;
import com.zyt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class InitialController {

    @Autowired
    InitialService initialService;

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
        Role role = initialService.getRoleByRemarks(remarks);
        List<RoleMenu> roleMenuList = initialService.getRoleMenu(role.getRoleId());
        List<Menu> menus = new ArrayList<>();
        for (RoleMenu roleMenu : roleMenuList){
            menus.add(initialService.getMenu(roleMenu.getMenuId()));
        }
        return menus;
    }

    @RequestMapping("/getLogs")
    public List<Log> getLogs(int page,int size){
        return initialService.findAllLogs(page,size);
    }

    @RequestMapping("/getDamageCount")
    public Integer getDamageCount(){
        return initialService.getDamage();
    }
}
