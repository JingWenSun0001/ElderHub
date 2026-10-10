package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 护理执行记录表
 * @TableName nurse_record
 */
@TableName(value ="nurse_record")
@Data
public class NurseRecord {
    /**
     * 记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户ID
     */
    @TableField(value = "customer_id")
    private Integer customer_id;

    /**
     * 护理项目ID
     */
    @TableField(value = "item_id")
    private Integer item_id;

    /**
     * 执行护理人员ID
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 护理执行时间
     */
    @TableField(value = "nursing_time")
    private LocalDateTime nursing_time;

    /**
     * 本次护理内容
     */
    @TableField(value = "nursing_content")
    private String nursing_content;

    /**
     * 本次执行次数
     */
    @TableField(value = "nursing_count")
    private Integer nursing_count;

    /**
     * 逻辑删除（0:正常 1:删除）
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;
}