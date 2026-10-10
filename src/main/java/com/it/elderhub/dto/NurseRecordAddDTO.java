package com.it.elderhub.dto;

import lombok.Data;

import java.util.Date;

/**
 * 录入护理记录请求DTO
 */
@Data
public class NurseRecordAddDTO {

    /**
     * 客户ID
     */
    private Integer customerId;

    /**
     * 护理项目ID
     */
    private Integer itemId;

    /**
     * 护理时间
     */
    private Date nursingTime;

    /**
     * 护理内容描述
     */
    private String nursingContent;

    /**
     * 护理次数（扣减客户项目数量）
     */
    private Integer nursingCount;
}
