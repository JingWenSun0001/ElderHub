package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.entity.Menu;
import com.it.elderhub.service.MenuService;
import com.it.elderhub.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author Ljz
* @description 针对表【menu(菜单路由表)】的数据库操作Service实现
* @createDate 2026-10-08 09:52:06
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




