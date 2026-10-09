package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.dto.OutwardAddDTO;
import com.it.elderhub.dto.OutwardQuery;
import com.it.elderhub.service.OutwardService;
import com.it.elderhub.vo.PageResult;
import com.it.elderhub.vo.OutwardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/nurse/outward")
public class NurseOutwardController {

    @Autowired
    private OutwardService outwardService;

    @PostMapping("/save")
    public Result<Void> save(@RequestBody OutwardAddDTO dto) {
        outwardService.saveOutward(dto);
        return Result.success(null);
    }

    @GetMapping("/list")
    public Result<PageResult<OutwardVO>> list(OutwardQuery query, @RequestParam(defaultValue = "1") Integer userId) {
        return Result.success(outwardService.listNurseOutwards(query, userId));
    }

    @PutMapping("/return")
    public Result<Void> registerReturn(@RequestParam Integer id) {
        // 实际回院时间直接由后端记录当前时间
        outwardService.registerReturn(id, new Date());
        return Result.success(null);
    }
}