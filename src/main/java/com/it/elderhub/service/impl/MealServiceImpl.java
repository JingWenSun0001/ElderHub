package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.entity.Meal;
import com.it.elderhub.service.MealService;
import com.it.elderhub.mapper.MealMapper;
import org.springframework.stereotype.Service;

/**
* @author Ljz
* @description 针对表【meal(膳食日历表)】的数据库操作Service实现
* @createDate 2026-10-08 09:52:06
*/
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal>
    implements MealService{

}




