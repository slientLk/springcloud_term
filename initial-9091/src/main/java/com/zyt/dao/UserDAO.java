package com.zyt.dao;


import com.inventory.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDAO extends PagingAndSortingRepository<User,Integer> {
    User getByUserId(Integer userId);
}
