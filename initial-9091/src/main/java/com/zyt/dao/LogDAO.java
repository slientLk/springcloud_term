package com.zyt.dao;

import com.inventory.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LogDAO extends PagingAndSortingRepository<Log,Integer> {
    Page<Log> findAll(Pageable pageable);
}
