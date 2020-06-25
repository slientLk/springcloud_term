package com.zyt.controller;

import com.inventory.entity.Menu;
import com.zyt.service.InitialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InitialController {

    @Autowired
    InitialService initialService;

    @GetMapping("/getMenuList")
    public List<Menu> getMenuList(String remarks){
        return initialService.getMenuList(remarks);
    }
}
