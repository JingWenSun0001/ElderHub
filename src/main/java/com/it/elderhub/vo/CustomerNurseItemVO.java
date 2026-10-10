package com.it.elderhub.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户护理项目VO（含项目信息和状态）
 */
@Data
public class CustomerNurseItemVO {

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
     * 护理级别ID
     */
    private Integer levelId;

    /**
     * 购买数量（剩余次数）
     */
    private Integer nurseNumber;

    /**
     * 购买时间
     */
    private Date buyTime;

    /**
     * 到期时间
     */
    private Date maturityTime;

    /**
     * 护理项目名称
     */
    private String nursingName;

    /**
     * 项目编号
     */
    private String serialNumber;

    /**
     * 服务价格
     */
    private BigDecimal servicePrice;

    /**
     * 项目状态（1:正常 2:到期 3:欠费）
     */
    private Integer status;

    /**
     * 状态描述
     */
    private String statusDesc;
}
