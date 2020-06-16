package com.zyt.service;


import com.inventory.entity.User;
import com.zyt.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    public User getByUserId(Integer userId){
        return userDAO.getByUserId(userId);
    }
}
