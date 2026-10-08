package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 床位使用详情表
 * @TableName bed_details
 */
@TableName(value ="bed_details")
@Data
public class BedDetails {
    /**
     * 详情ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 床位ID
     */
    @TableField(value = "bed_id")
    private Integer bed_id;

    /**
     * 入住客户ID
     */
    @TableField(value = "customer_id")
    private Integer customer_id;

    /**
     * 入住开始日期
     */
    @TableField(value = "start_date")
    private Date start_date;

    /**
     * 退住结束日期
     */
    @TableField(value = "end_date")
    private Date end_date;

    /**
     * 床位详情说明
     */
    @TableField(value = "bed_details")
    private String bed_details;

    /**
     * 逻辑删除（0:正常 1:删除）
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;
}