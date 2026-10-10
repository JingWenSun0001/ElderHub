package com.it.elderhub.service;

import com.it.elderhub.dto.NurseRecordAddDTO;
import com.it.elderhub.entity.NurseRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.elderhub.vo.NurseRecordVO;

import java.util.List;

/**
* @author Ljz
* @description 针对表【nurse_record(护理执行记录表)】的数据库操作Service
* @createDate 2026-10-08 09:52:06
*/
public interface NurseRecordService extends IService<NurseRecord> {
    // 管理员查看客户护理记录
    List<NurseRecordVO> listNurseRecords(Integer customerId);
    // 管家查看自己客户的护理记录
    List<NurseRecordVO> listNurseRecordsByUserId(Integer userId);
    // 录入护理记录（核心：保存记录并扣减客户项目次数）
    void saveNurseRecord(NurseRecordAddDTO dto);
    // 逻辑删除记录
    void removeNurseRecord(Integer id);
}
