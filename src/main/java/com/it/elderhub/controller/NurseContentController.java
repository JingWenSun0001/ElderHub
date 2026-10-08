package com.it.elderhub.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.elderhub.common.Result;
import com.it.elderhub.entity.NurseContent;
import com.it.elderhub.service.NurseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 护理项目Controller
 */
@RestController
@RequestMapping("/admin/nurse-content")
public class NurseContentController {

    @Autowired
    private NurseContentService nurseContentService;

    /**
     * 分页查询护理项目
     * @param pageNum 页码（默认1）
     * @param pageSize 每页条数（默认10）
     * @param status 项目状态（可空）
     * @param nursingName 项目名称模糊查询（可空）
     */
    @GetMapping("/list")
    public Result<IPage<NurseContent>> list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Integer status,
            String nursingName) {
        return Result.success(nurseContentService.listContents(pageNum, pageSize, status, nursingName));
    }

    /**
     * 新增护理项目
     */
    @PostMapping("/save")
    public Result<Void> save(@RequestBody NurseContent content) {
        nurseContentService.saveContent(content);
        return Result.success();
    }

    /**
     * 修改护理项目
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody NurseContent content) {
        nurseContentService.updateContent(content);
        return Result.success();
    }

    /**
     * 删除护理项目（逻辑删除）
     * @param id 项目ID
     */
    @DeleteMapping("/remove/{id}")
    public Result<Void> remove(@PathVariable Integer id) {
        nurseContentService.removeContent(id);
        return Result.success();
    }
}
