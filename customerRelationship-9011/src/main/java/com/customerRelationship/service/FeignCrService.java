package com.customerRelationship.service;

import com.customerRelationship.entity.TCustomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="crship",fallback = FeignCrService.class)
public interface FeignCrService {



    @GetMapping("/tclist")
    public List<TCustomer> tcList();

    @GetMapping("/getById1")
    public TCustomer getById1(Integer customerId);

    @GetMapping("/updata")
    public TCustomer updata(Integer customerId);

    @GetMapping("/add")
    public List<TCustomer> add();

    @GetMapping("/delete")
    public List<TCustomer> delete(Integer customerId);


}
