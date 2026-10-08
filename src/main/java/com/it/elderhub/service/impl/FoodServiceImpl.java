package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.entity.Food;
import com.it.elderhub.service.FoodService;
import com.it.elderhub.mapper.FoodMapper;
import org.springframework.stereotype.Service;

/**
* @author Ljz
* @description 针对表【food(食品信息表)】的数据库操作Service实现
* @createDate 2026-10-08 09:52:06
*/
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
    implements FoodService{

}




