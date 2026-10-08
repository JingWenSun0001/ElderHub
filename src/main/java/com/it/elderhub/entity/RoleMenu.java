package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色菜单关联表
 * @TableName role_menu
 */
@TableName(value ="role_menu")
@Data
public class RoleMenu {
    /**
     * 关联ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Integer role_id;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Integer menu_id;
}