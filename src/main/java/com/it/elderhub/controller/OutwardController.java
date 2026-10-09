package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.dto.OutwardQuery;
import com.it.elderhub.service.OutwardService;
import com.it.elderhub.vo.PageResult;
import com.it.elderhub.vo.OutwardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/outward")
public class OutwardController {

    @Autowired
    private OutwardService outwardService;

    @GetMapping("/list")
    public Result<PageResult<OutwardVO>> list(OutwardQuery query) {
        return Result.success(outwardService.listOutwards(query));
    }

    @PutMapping("/audit")
    public Result<Void> audit(@RequestParam Integer id,
                              @RequestParam Integer auditStatus,
                              @RequestParam String auditPerson) {
        outwardService.auditOutward(id, auditStatus, auditPerson);
        return Result.success(null);
    }
}