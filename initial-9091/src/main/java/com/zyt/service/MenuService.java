package com.zyt.service;

import com.inventory.entity.Menu;
import com.zyt.dao.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuDAO menuDAO;

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    public Menu getMenu(Integer pid){
        return menuDAO.findByMenuId(pid);
    }
}
