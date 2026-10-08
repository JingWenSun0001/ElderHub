package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 菜单路由表
 * @TableName menu
 */
@TableName(value ="menu")
@Data
public class Menu {
    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 一级菜单索引
     */
    @TableField(value = "menus_index")
    private String menus_index;

    /**
     * 菜单标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 前端路由路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 父菜单ID（0为一级菜单）
     */
    @TableField(value = "parent_id")
    private Integer parent_id;
}