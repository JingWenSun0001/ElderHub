package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.entity.CustomerPreference;
import com.it.elderhub.service.CustomerPreferenceService;
import com.it.elderhub.mapper.CustomerPreferenceMapper;
import org.springframework.stereotype.Service;

/**
* @author Ljz
* @description 针对表【customer_preference(客户饮食喜好表)】的数据库操作Service实现
* @createDate 2026-10-08 09:52:06
*/
@Service
public class CustomerPreferenceServiceImpl extends ServiceImpl<CustomerPreferenceMapper, CustomerPreference>
    implements CustomerPreferenceService{

}




