package com.it.elderhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.elderhub.dto.NurseRecordAddDTO;
import com.it.elderhub.entity.*;
import com.it.elderhub.mapper.*;
import com.it.elderhub.service.NurseRecordService;
import com.it.elderhub.vo.NurseRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NurseRecordServiceImpl extends ServiceImpl<NurseRecordMapper, NurseRecord> implements NurseRecordService {

    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;
    @Autowired
    private NurseContentMapper nurseContentMapper;

    @Override
    public List<NurseRecordVO> listNurseRecords(Integer customerId) {
        return getRecordsWithJoin(customerId, null);
    }

    @Override
    public List<NurseRecordVO> listNurseRecordsByUserId(Integer userId) {
        return getRecordsWithJoin(null, userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveNurseRecord(NurseRecordAddDTO dto) {
        // 1. 插入护理记录
        NurseRecord record = new NurseRecord();
        record.setCustomer_id(dto.getCustomerId());
        record.setItem_id(dto.getItemId());
        record.setUser_id(dto.getUserId());
        record.setNursing_time(dto.getNursingTime());
        record.setNursing_content(dto.getNursingContent());
        record.setNursing_count(dto.getNursingCount());
        record.setIs_deleted(0);
        this.save(record);

        // 2. 扣减客户护理项目 (customer_nurse_item) 的剩余次数
        LambdaQueryWrapper<CustomerNurseItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerNurseItem::getCustomer_id, dto.getCustomerId())
                .eq(CustomerNurseItem::getItem_id, dto.getItemId());

        CustomerNurseItem item = customerNurseItemMapper.selectOne(wrapper);
        if (item != null) {
            // 核心逻辑：nurseNumber = 原有数量 - nursingCount
            int newNumber = item.getNurse_number() - dto.getNursingCount();
            item.setNurse_number(newNumber);
            customerNurseItemMapper.updateById(item);
            log.info("成功录入记录并扣减次数，项目ID: {}，剩余次数: {}", item.getId(), newNumber);
        } else {
            log.warn("扣减次数失败，未找到客户[{}]的项目[{}]。", dto.getCustomerId(), dto.getItemId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeNurseRecord(Integer id) {
        // 逻辑删除，使用 MyBatis-Plus 自带的 removeById 即可（配合 @TableLogic）
        this.removeById(id);
    }

    /**
     * 内部私有方法：联合查询记录与项目名称
     */
    private List<NurseRecordVO> getRecordsWithJoin(Integer customerId, Integer userId) {
        LambdaQueryWrapper<NurseRecord> wrapper = new LambdaQueryWrapper<>();
        if (customerId != null) {
            wrapper.eq(NurseRecord::getCustomer_id, customerId);
        }
        if (userId != null) {
            wrapper.eq(NurseRecord::getUser_id, userId);
        }
        wrapper.orderByDesc(NurseRecord::getNursing_time); // 按时间倒序排列
        List<NurseRecord> records = this.list(wrapper);

        if (records.isEmpty()) return List.of();

        // 提取所有关联的项目ID，批量查询项目名称
        List<Integer> itemIds = records.stream()
                .map(NurseRecord::getItem_id)
                .distinct()
                .collect(Collectors.toList());

        List<NurseContent> contents = nurseContentMapper.selectBatchIds(itemIds);

        // 建立 id -> nursingName 的映射
        Map<Integer, String> nameMap = contents.stream()
                .collect(Collectors.toMap(NurseContent::getId, NurseContent::getNursing_name, (v1, v2) -> v1));

        // 转换为 VO
        return records.stream().map(record -> {
            NurseRecordVO vo = new NurseRecordVO();
            vo.setId(record.getId());
            vo.setCustomerId(record.getCustomer_id());
            vo.setItemId(record.getItem_id());
            vo.setUserId(record.getUser_id());
            vo.setNursingName(nameMap.getOrDefault(record.getItem_id(), "未知项目"));
            vo.setNursingTime(record.getNursing_time());
            vo.setNursingContent(record.getNursing_content());
            vo.setNursingCount(record.getNursing_count());
            return vo;
        }).collect(Collectors.toList());
    }
}