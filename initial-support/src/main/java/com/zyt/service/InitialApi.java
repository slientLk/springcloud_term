package com.zyt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "initial",fallback = InitialError.class)
public interface InitialApi {
    @GetMapping("/getRoleByRemarks")
    public String getMenuByRemarks(@RequestParam("remarks") String remarks);
}
