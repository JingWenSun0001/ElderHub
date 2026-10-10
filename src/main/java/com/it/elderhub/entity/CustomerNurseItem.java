package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

/**
 * 客户已购护理条目表
 * @TableName customer_nurse_item
 */
@TableName(value ="customer_nurse_item")
@Data
public class CustomerNurseItem {
    /**
     * 条目ID
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
     * 护理等级ID
     */
    @TableField(value = "level_id")
    private Integer level_id;

    /**
     * 购买服务次数
     */
    @TableField(value = "nurse_number")
    private Integer nurse_number;

    /**
     * 购买日期
     */
    @TableField(value = "buy_time")
    private LocalDate buy_time;

    /**
     * 服务到期日期
     */
    @TableField(value = "maturity_time")
    private LocalDate maturity_time;

    /**
     * 逻辑删除（0:正常 1:删除）
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;
}