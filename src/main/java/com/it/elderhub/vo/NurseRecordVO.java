package com.it.elderhub.vo;

import lombok.Data;

import java.util.Date;

/**
 * 护理记录VO（含项目名称）
 */
@Data
public class NurseRecordVO {

    /**
     * 记录ID
     */
    private Integer id;

    /**
     * 客户ID
     */
    private Integer customerId;

    /**
     * 护理项目ID
     */
    private Integer itemId;

    /**
     * 护理人员ID
     */
    private Integer userId;

    /**
     * 护理时间
     */
    private Date nursingTime;

    /**
     * 护理内容
     */
    private String nursingContent;

    /**
     * 护理次数
     */
    private Integer nursingCount;

    /**
     * 护理项目名称
     */
    private String nursingName;

    /**
     * 创建时间
     */
    private Date createTime;
}
