package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.service.NurseRecordService;
import com.it.elderhub.vo.NurseRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/nurse-record")
public class NurseRecordAdminController {

    @Autowired
    private NurseRecordService nurseRecordService;

    /**
     * 管理员：查看客户护理记录
     * GET /admin/nurse-record/list/{customerId}
     */
    @GetMapping("/list/{customerId}")
    public Result<List<NurseRecordVO>> getAdminList(@PathVariable Integer customerId) {
        return Result.success(nurseRecordService.listNurseRecords(customerId));
    }

    /**
     * 管理员：逻辑删除护理记录
     * DELETE /admin/nurse-record/remove/{id}
     */
    @DeleteMapping("/remove/{id}")
    public Result<Void> remove(@PathVariable Integer id) {
        nurseRecordService.removeNurseRecord(id);
        return Result.success(null);
    }
}