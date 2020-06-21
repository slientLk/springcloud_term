package com.feign.service;

import com.inventory.entity.Log;
import com.inventory.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialError implements InitialFeign{
    @Override
    public List<String> getBasicMenu() {
        List<String> error = new ArrayList<>();
        error.add("getBasicMenu is down!");
        return error;
    }

    @Override
    public List<Menu> getMenuByRemarks(String remarks){
        return null;
    }

    @Override
    public List<Log> getLogs(int page, int size) {
        return null;
    }

    @Override
    public Integer getDamageCount() {
        return -1;
    }
}
