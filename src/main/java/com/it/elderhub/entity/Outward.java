package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 外出登记表
 * @TableName outward
 */
@TableName(value ="outward")
@Data
public class Outward {
    /**
     * 登记ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户ID
     */
    @TableField(value = "customer_id")
    private Integer customer_id;

    /**
     * 外出事由
     */
    @TableField(value = "outgoingreason")
    private String outgoingreason;

    /**
     * 外出时间
     */
    @TableField(value = "outgoingtime")
    private Date outgoingtime;

    /**
     * 预计回院时间
     */
    @TableField(value = "expectedreturntime")
    private Date expectedreturntime;

    /**
     * 实际回院时间
     */
    @TableField(value = "actualreturntime")
    private Date actualreturntime;

    /**
     * 陪同人姓名
     */
    @TableField(value = "escorted")
    private String escorted;

    /**
     * 陪同人与老人关系
     */
    @TableField(value = "relation")
    private String relation;

    /**
     * 陪同人联系电话
     */
    @TableField(value = "escortedtel")
    private String escortedtel;

    /**
     * 审批状态（0:已提交 1:同意 2:拒绝）
     */
    @TableField(value = "auditstatus")
    private Integer auditstatus;

    /**
     * 审批人姓名
     */
    @TableField(value = "auditperson")
    private String auditperson;

    /**
     * 审批时间
     */
    @TableField(value = "audittime")
    private Date audittime;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 逻辑删除（0:正常 1:删除）
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;
}