package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.entity.User;
import com.it.elderhub.service.UserService;
import com.it.elderhub.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Ljz
* @description 针对表【user(系统用户表)】的数据库操作Service实现
* @createDate 2026-10-08 09:52:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




