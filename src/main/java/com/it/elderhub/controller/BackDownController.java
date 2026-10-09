package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.dto.BackDownQuery;
import com.it.elderhub.service.BackdownService;
import com.it.elderhub.vo.BackDownVO;
import com.it.elderhub.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/back-down")
public class BackDownController {

    @Autowired
    private BackdownService backDownService;

    @GetMapping("/list")
    public Result<PageResult<BackDownVO>> list(BackDownQuery query) {
        return Result.success(backDownService.listBackDowns(query));
    }

    @PutMapping("/audit")
    public Result<Void> audit(@RequestParam Integer id,
                              @RequestParam Integer auditStatus,
                              @RequestParam String auditPerson) {
        // 实际项目中 auditPerson 应从 Session 获取，这里为了测试直接透传
        backDownService.auditBackDown(id, auditStatus, auditPerson);
        return Result.success(null);
    }
}