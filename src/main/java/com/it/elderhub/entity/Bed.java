package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 床位信息表
 * @TableName bed
 */
@TableName(value ="bed")
@Data
public class Bed {
    /**
     * 床位ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 床位编号
     */
    @TableField(value = "bed_no")
    private String bed_no;

    /**
     * 所属房间编号
     */
    @TableField(value = "room_no")
    private Integer room_no;

    /**
     * 床位状态（1:空闲 2:已入住 3:外出）
     */
    @TableField(value = "bed_status")
    private Integer bed_status;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;
}