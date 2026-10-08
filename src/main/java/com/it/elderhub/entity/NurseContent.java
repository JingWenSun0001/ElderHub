package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 护理项目内容表
 * @TableName nurse_content
 */
@TableName(value ="nurse_content")
@Data
public class NurseContent {
    /**
     * 护理项目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目编号
     */
    @TableField(value = "serial_number")
    private String serial_number;

    /**
     * 护理项目名称
     */
    @TableField(value = "nursing_name")
    private String nursing_name;

    /**
     * 服务价格
     */
    @TableField(value = "service_price")
    private BigDecimal service_price;

    /**
     * 项目描述
     */
    @TableField(value = "message")
    private String message;

    /**
     * 执行周期
     */
    @TableField(value = "execution_cycle")
    private String execution_cycle;

    /**
     * 执行次数
     */
    @TableField(value = "execution_times")
    private String execution_times;

    /**
     * 状态（1:启用 2:停用）
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 逻辑删除（0:正常 1:删除）
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;
}