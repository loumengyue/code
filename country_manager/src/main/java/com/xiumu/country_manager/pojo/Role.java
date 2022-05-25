package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  角色管理   一个人  一个角色
 *
 */
@TableName("role_manage")
@Data
public class Role {
    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private int roleId;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 角色名称
     */
    private String roleName;

}
