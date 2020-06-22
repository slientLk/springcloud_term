package com.zyt.dao;

import com.inventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String userName,String password);
}
