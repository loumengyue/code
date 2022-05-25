package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 党建管理-党员信息
 *
 */
@TableName("member_manage")
@Data
public class Member {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private int id;
    /**
     * 党员编号
     */
    private int memberId;
    /**
     * 党员姓名
     */
    private String memberName;
    /**
     * 党员状态（0在档1，离党）
     */
    private int memberStatus;
    /**
     * 人员身份（0党员 1积极分子）
     */
    private int memberIdentity;
    /**
     * 党员入党时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date memberStartTime;
    /**
     * 党员离党时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date memberEndTime;
    /**
     * 成为积极分子时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date memberActiveTime;
    /**
     * 党员所在党组织id
     */
    private int memberPartyId;
    @TableField(exist = false)
    private Party party;
}
