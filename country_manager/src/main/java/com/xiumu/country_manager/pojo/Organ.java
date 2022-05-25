package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *  机构管理  村委下面的机构
 *
 */
@TableName("organ_manage")
@Data
public class Organ {
    /**
     * 机构id
     */
    @TableId(type = IdType.AUTO)
    private int organId;
    /**
     * 机构名称
     */
    private String organName;
    /**
     * 机构职责
     */
    private String organDuty;
    /**
     * 机构负责人
     */
    private String organLeader;
    /**
     * 机构公共电话
     */
    private String organPhone;
    /**
     * 机构负责人电话
     */
    private String organLeaderPhone;
    /**
     * 机构成立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date organTime;

    /**
     * 机构所属村委
     */
    private int organVillageId;
    @TableField(exist = false)
    private Village village;
}
