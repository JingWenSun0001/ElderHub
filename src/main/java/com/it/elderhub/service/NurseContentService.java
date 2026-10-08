package com.it.elderhub.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.elderhub.entity.NurseContent;

/**
 * 护理项目Service接口
 */
public interface NurseContentService {

    /**
     * 分页查询护理项目
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param status 项目状态（可空）
     * @param nursingName 项目名称模糊查询（可空）
     * @return 分页结果
     */
    IPage<NurseContent> listContents(Integer pageNum, Integer pageSize, Integer status, String nursingName);

    /**
     * 新增护理项目
     * @param content 项目信息
     */
    void saveContent(NurseContent content);

    /**
     * 修改护理项目
     * @param content 项目信息（必须带ID）
     */
    void updateContent(NurseContent content);

    /**
     * 删除护理项目（逻辑删除，同时删除级别关联）
     * @param id 项目ID
     */
    void removeContent(Integer id);
}
