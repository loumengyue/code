package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *  活动管理
 *
 */
@TableName("activity_manage")
@Data
public class Activity {
    /**
     * 活动id
     */
    @TableId(type = IdType.AUTO)
    private int activityId;
    /**
     * 活动类型
     */
    private String activityType;
    /**
     * 活动具体内容
     */
    private String activityContent;
    /**
     * 活动开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityStartTime;
    /**
     * 活动结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;
    /**
     * 活动发起机构id
     */
    private int activityOrganId;
    /**
     * 活动针对人群
     */
    private String activityPerson;
    @TableField(exist = false)
    private Organ organ;

}
