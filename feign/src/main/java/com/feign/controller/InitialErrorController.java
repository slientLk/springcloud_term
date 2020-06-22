package com.feign.controller;

import com.feign.service.InitialFeign;
import com.inventory.entity.Log;
import com.inventory.entity.Menu;
import com.inventory.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/initial")
public class InitialErrorController {

    @Resource
    private InitialFeign initialFeign;

    @RequestMapping("/login")
    public User login(String username, String password){
        return initialFeign.login(username,password);
    }

    @GetMapping("/getMenuByRemarks")
    public List<Menu> getMenuByRemarks(String remarks){
        return initialFeign.getMenuByRemarks(remarks);
    }

    @GetMapping("/getLogs")
    public List<Log> getLogs(Integer page, Integer size){
        return initialFeign.getLogs(page,size);
    }

    @GetMapping("/getDamageCount")
    public Integer getDamageCount(){
        return initialFeign.getDamageCount();
    }
}