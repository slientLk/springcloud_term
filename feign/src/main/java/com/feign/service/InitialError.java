package com.feign.service;

import com.inventory.entity.Log;
import com.inventory.entity.Menu;
import com.inventory.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialError implements InitialFeign{
    @Override
    public User login(String username, String password) {
        return null;
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
