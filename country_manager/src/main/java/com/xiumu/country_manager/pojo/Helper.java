package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *  帮扶对象管理
 *
 */
@TableName("helper_manage")
@Data
public class Helper {
    /**
     * 帮扶id
     */
    @TableId(type = IdType.AUTO)
    private int helperId;
    /**
     * 帮扶对象id
     *
     */
    private String helperPopulationId;
    /**
     * 帮扶类型
     */
    private String helperType;
    /**
     * 帮扶时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date helperTime;
    /**
     * 帮扶对象所处状态 0 未帮扶  1 帮扶中  2  帮扶结束
     */
    private int helperStatus;
    /**
     * 帮扶得执行者
     */
    private String helperExecuted;
    /**
     * 帮扶对象所属村委id
     */
    private int helperVillageId;

    @TableField(exist = false)
    private Population population;
    @TableField(exist = false)
    private Village village;

}
