package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.dto.BackDownAddDTO;
import com.it.elderhub.dto.BackDownQuery;
import com.it.elderhub.service.BackdownService;
import com.it.elderhub.vo.BackDownVO;
import com.it.elderhub.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nurse/back-down")
public class NurseBackDownController {

    @Autowired
    private BackdownService backDownService;

    @PostMapping("/save")
    public Result<Void> save(@RequestBody BackDownAddDTO dto) {
        backDownService.saveBackDown(dto);
        return Result.success(null);
    }

    @GetMapping("/list")
    public Result<PageResult<BackDownVO>> list(BackDownQuery query,
                                               @RequestParam(defaultValue = "1") Integer userId) {
        // 实际项目中 userId 应从 Session 获取
        return Result.success(backDownService.listNurseBackDowns(query, userId));
    }
}