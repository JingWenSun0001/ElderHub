package com.it.elderhub.service;

import com.it.elderhub.dto.BackDownAddDTO;
import com.it.elderhub.dto.BackDownQuery;
import com.it.elderhub.entity.Backdown;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.elderhub.vo.BackDownVO;
import com.it.elderhub.vo.PageResult;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Ljz
* @description 针对表【backdown(退住登记表)】的数据库操作Service
* @createDate 2026-10-08 09:52:05
*/
@Mapper
public interface BackdownService extends IService<Backdown> {

    PageResult<BackDownVO> listBackDowns(BackDownQuery query);

    void auditBackDown(Integer id,Integer auditStatus,String auditPerson);

    void saveBackDown(BackDownAddDTO dto);

    public PageResult<BackDownVO> listNurseBackDowns(BackDownQuery query,Integer userId);

}
