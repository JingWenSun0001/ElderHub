package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 护理等级表
 * @TableName nurse_level
 */
@TableName(value ="nurse_level")
@Data
public class NurseLevel {
    /**
     * 护理等级ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 等级名称
     */
    @TableField(value = "level_name")
    private String level_name;

    /**
     * 状态（1:启用 2:停用）
     */
    @TableField(value = "level_status")
    private Integer level_status;

    /**
     * 逻辑删除（0:正常 1:删除）
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;
}