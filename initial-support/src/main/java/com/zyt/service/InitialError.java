package com.zyt.service;

import org.springframework.stereotype.Component;

@Component
public class InitialError implements InitialApi{
    @Override
    public String getMenuByRemarks(String remarks) {
        return "serviceStop";
    }
}
