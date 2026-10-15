package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.dto.NurseRecordAddDTO;
import com.it.elderhub.service.NurseDailyService;
import com.it.elderhub.service.NurseRecordService;
import com.it.elderhub.vo.NurseRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 管家：录入护理记录
 * POST /nurse/nurse-record-mine/save
 */
@RestController
@RequestMapping("/nurse/nurse-record-mine")
public class NurseRecordButlerController {

    @Autowired
    private NurseRecordService nurseRecordService;

    @Autowired
    private NurseDailyService nurseDailyService;

    /**
     * 管家：录入护理记录（校验客户归属 + 剩余次数，并扣减次数）
     * POST /nurse/nurse-record-mine/save
     */
    @PostMapping("/save")
    public Result<Void> save(@RequestBody NurseRecordAddDTO dto) {
        if (dto.getUserId() == null) {
            throw new RuntimeException("缺少管家用户ID");
        }
        nurseDailyService.saveNurseRecord(dto, dto.getUserId());
        return Result.success(null);
    }

    /**
     * 管家：查看护理记录
     * GET /nurse/nurse-record-mine/list?customerId=&userId=
     * customerId 为空时返回该管家名下全部客户记录，不为空时只返回指定客户记录
     */
    @GetMapping("/list")
    public Result<List<NurseRecordVO>> getButlerList(
            @RequestParam(required = false) Integer customerId,
            @RequestParam Integer userId) {
        if (customerId == null) {
            return Result.success(nurseRecordService.listNurseRecordsByUserId(userId));
        }
        return Result.success(nurseDailyService.listNurseRecords(customerId, userId));
    }
}
