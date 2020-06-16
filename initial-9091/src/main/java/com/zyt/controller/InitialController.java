package com.zyt.controller;


import com.inventory.entity.User;
import com.zyt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Init")
@ResponseBody
public class InitialController {

    @Autowired
    UserService userService;

    @RequestMapping("/getMenu")
    public List<String> getMenu(Integer UserId){
        User user = userService.getByUserId(UserId);
        List<String> menuList;
        System.out.println("====="+user.getRemarks());
        if (user.getRemarks().equals("管理员")){
            menuList = new ArrayList<String>();
            menuList.add("登陆");
            menuList.add("后台管理");
            menuList.add("注销");
        } else if (user.getRemarks().equals("销售经理")){
            menuList = new ArrayList<String>();
            menuList.add("登陆");
            menuList.add("仓库管理");
            menuList.add("销售管理");
            menuList.add("采购管理");
            menuList.add("注销");
        }else {
            menuList = new ArrayList<String>();
            menuList.add("后台管理");
            menuList.add("注销");
        }
        return menuList;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
