package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 房间信息表
 * @TableName room
 */
@TableName(value ="room")
@Data
public class Room {
    /**
     * 房间ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所在楼层
     */
    @TableField(value = "room_floor")
    private String room_floor;

    /**
     * 房间编号
     */
    @TableField(value = "room_no")
    private Integer room_no;
}