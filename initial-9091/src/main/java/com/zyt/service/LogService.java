package com.zyt.service;

import com.inventory.entity.Log;
import com.zyt.dao.LogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    LogDAO logDAO;

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    public List<Log> findAllLogs(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<Log> logs = logDAO.findAll(pageable);
        return logs.getContent();
    }
}
