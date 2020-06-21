package com.feign.service;

import com.inventory.entity.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.inventory.entity.Menu;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "initial",fallback = InitialError.class)
public interface InitialFeign {
    @GetMapping("/getBasicMenu")
    public List<String> getBasicMenu();

    @GetMapping("/getMenuByRemarks")
    public List<Menu> getMenuByRemarks(@RequestParam("remarks") String remarks);

    @GetMapping("/getLogs")
    public List<Log> getLogs(@RequestParam("page") int page,@RequestParam("size") int size);

    @GetMapping("/getDamageCount")
    public Integer getDamageCount();
}
