package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.entity.Customer;
import com.it.elderhub.service.CustomerService;
import com.it.elderhub.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

/**
* @author Ljz
* @description 针对表【customer(在住客户/老人表)】的数据库操作Service实现
* @createDate 2026-10-08 09:52:05
*/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
    implements CustomerService{

}




