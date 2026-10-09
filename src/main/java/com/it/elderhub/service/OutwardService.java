package com.it.elderhub.service;

import com.it.elderhub.dto.OutwardAddDTO;
import com.it.elderhub.dto.OutwardQuery;
import com.it.elderhub.entity.Outward;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.elderhub.vo.OutwardVO;
import com.it.elderhub.vo.PageResult;

import java.util.Date;

/**
* @author Ljz
* @description 针对表【outward(外出登记表)】的数据库操作Service
* @createDate 2026-10-08 09:52:06
*/
public interface OutwardService extends IService<Outward> {

    PageResult<OutwardVO> listOutwards(OutwardQuery query);

    void auditOutward(Integer id, Integer auditStatus, String auditPerson);

    void saveOutward(OutwardAddDTO dto);

    PageResult<OutwardVO> listNurseOutwards(OutwardQuery query, Integer userId);

    void registerReturn(Integer id, Date actualReturnTime);
}
