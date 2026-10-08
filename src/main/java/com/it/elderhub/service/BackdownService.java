package com.it.elderhub.service;

import com.it.elderhub.entity.Backdown;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Ljz
* @description 针对表【backdown(退住登记表)】的数据库操作Service
* @createDate 2026-10-08 09:52:05
*/
@Mapper
public interface BackdownService extends IService<Backdown> {

}
