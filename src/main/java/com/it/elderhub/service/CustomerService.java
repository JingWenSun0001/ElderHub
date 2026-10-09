package com.it.elderhub.service;

import com.it.elderhub.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Ljz
* @description 针对表【customer(在住客户/老人表)】的数据库操作Service
* @createDate 2026-10-08 09:52:05
*/
public interface CustomerService extends IService<Customer> {

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void removeCustomer(Integer id);

    void goOut(Integer id);

    void comeback(Integer id);

    List<Customer> listNoNurse();
}
