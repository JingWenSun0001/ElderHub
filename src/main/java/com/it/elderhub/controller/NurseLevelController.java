package com.it.elderhub.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.elderhub.common.Result;
import com.it.elderhub.entity.NurseContent;
import com.it.elderhub.entity.NurseLevel;
import com.it.elderhub.service.NurseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 护理级别Controller
 */
@RestController
@RequestMapping("/admin/nurse-level")
public class NurseLevelController {

    @Autowired
    private NurseLevelService nurseLevelService;

    /**
     * 分页查询护理级别
     * @param pageNum 页码（默认1）
     * @param pageSize 每页条数（默认10）
     * @param levelStatus 级别状态（可空）
     */
    @GetMapping("/list")
    public Result<IPage<NurseLevel>> list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Integer levelStatus) {
        return Result.success(nurseLevelService.listLevels(pageNum, pageSize, levelStatus));
    }

    /**
     * 新增护理级别
     */
    @PostMapping("/save")
    public Result<Void> save(@RequestBody NurseLevel level) {
        nurseLevelService.saveLevel(level);
        return Result.success();
    }

    /**
     * 修改级别状态（启用/停用）
     * @param id 级别ID
     * @param levelStatus 目标状态（1:启用 2:停用）
     */
    @PutMapping("/update-status")
    public Result<Void> updateStatus(@RequestParam Integer id, @RequestParam Integer levelStatus) {
        nurseLevelService.updateLevelStatus(id, levelStatus);
        return Result.success();
    }

    /**
     * 查询某级别下配置的护理项目
     * @param levelId 级别ID
     */
    @GetMapping("/items/{levelId}")
    public Result<List<NurseContent>> items(@PathVariable Integer levelId) {
        return Result.success(nurseLevelService.listLevelItems(levelId));
    }

    /**
     * 给级别添加护理项目
     * @param levelId 级别ID
     * @param itemId 项目ID
     */
    @PostMapping("/item/save")
    public Result<Void> saveItem(@RequestParam Integer levelId, @RequestParam Integer itemId) {
        nurseLevelService.saveLevelItem(levelId, itemId);
        return Result.success();
    }

    /**
     * 从级别移除护理项目
     * @param levelId 级别ID
     * @param itemId 项目ID
     */
    @DeleteMapping("/item/remove/{levelId}/{itemId}")
    public Result<Void> removeItem(@PathVariable Integer levelId, @PathVariable Integer itemId) {
        nurseLevelService.removeLevelItem(levelId, itemId);
        return Result.success();
    }
}
