package com.it.elderhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private Integer sex;

    private String phoneNumber;

    private String email;

    private Integer roleId;

    private LocalDateTime createTime;

    private Integer createBy;

    private LocalDateTime updateTime;

    private Integer updateBy;

    @TableLogic
    private Integer isDeleted;
}
