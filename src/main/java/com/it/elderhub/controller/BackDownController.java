package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.entity.Backdown;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;

@RestController
@RequestMapping("/admin/back-down")
public class BackDownController {
    //管理员分页管理
    public Result<PagedResult<BackdownVO>>

}
