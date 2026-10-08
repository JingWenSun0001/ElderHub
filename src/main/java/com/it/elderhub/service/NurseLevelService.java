package com.it.elderhub.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.elderhub.entity.NurseContent;
import com.it.elderhub.entity.NurseLevel;

import java.util.List;

/**
 * 护理级别Service接口
 */
public interface NurseLevelService {

    /**
     * 分页查询护理级别
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param levelStatus 级别状态（可空）
     * @return 分页结果
     */
    IPage<NurseLevel> listLevels(Integer pageNum, Integer pageSize, Integer levelStatus);

    /**
     * 新增护理级别
     * @param level 级别信息
     */
    void saveLevel(NurseLevel level);

    /**
     * 修改级别状态（启用/停用）
     * @param id 级别ID
     * @param levelStatus 目标状态
     */
    void updateLevelStatus(Integer id, Integer levelStatus);

    /**
     * 查询某级别下配置的护理项目
     * @param levelId 级别ID
     * @return 护理项目列表
     */
    List<NurseContent> listLevelItems(Integer levelId);

    /**
     * 给级别添加护理项目
     * @param levelId 级别ID
     * @param itemId 项目ID
     */
    void saveLevelItem(Integer levelId, Integer itemId);

    /**
     * 从级别移除护理项目
     * @param levelId 级别ID
     * @param itemId 项目ID
     */
    void removeLevelItem(Integer levelId, Integer itemId);
}
