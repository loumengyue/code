package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  村委人员-村委用户信息
 *
 */
@TableName("user_manage")
@Data
public class User {
    /**
     * 村委人事编号
     */
    @TableId(type = IdType.AUTO)
    private int userId;
    /**
     * 村委人事账号
     */
    private String userName;
    /**
     * 村委人事密码
     */
    private String password;
    /**
     * 人事性别
     */
    private String gender;
    /**
     * 人事电话
     */
    private String userPhone;
    /**
     * 村委人事姓名
     */
    private String nickName;
    /**
     * 村委人事拥有的角色id
     */
    private int userRoleId;
    /**
     * 村委人事所属村委id
     */
    private int userVillageId;
    /**
     * 村委人事状态
     */
    private String userStatus;
    /**
     * 村委离职信
     */
    private String userDesc;
    /**
     * 村委人事职务
     */
    private String userPost;
    @TableField(exist = false)
    private Role role;
    @TableField(exist = false)
    private Village village;
}
