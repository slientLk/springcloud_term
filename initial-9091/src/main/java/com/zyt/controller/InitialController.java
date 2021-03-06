package com.zyt.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.inventory.entity.*;
import com.zyt.service.*;
import org.codehaus.jettison.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/login")
    public User login(String username,String password){
        User user = initialService.getByUserNameAndPassword(username,password);
        if (user !=null)
            redisTemplate.opsForValue().set(user.getUserId(),user);
        User user1 = (User) redisTemplate.opsForValue().get(user.getUserId());
        System.out.println("登陆用户的TrueName："+user1.getTrueName());
        return user;
    }

    @RequestMapping("/getRoleByRemarks")
    public String getMenuList(String remarks){
        return JSONObject.toJSONString(initialService.getRoleByRemarks(remarks));
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
