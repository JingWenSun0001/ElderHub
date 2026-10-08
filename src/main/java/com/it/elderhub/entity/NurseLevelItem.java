package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 护理等级项目关联表
 * @TableName nurse_level_item
 */
@TableName(value ="nurse_level_item")
@Data
public class NurseLevelItem {
    /**
     * 关联ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 护理等级ID
     */
    @TableField(value = "level_id")
    private Integer level_id;

    /**
     * 护理项目ID
     */
    @TableField(value = "item_id")
    private Integer item_id;
}