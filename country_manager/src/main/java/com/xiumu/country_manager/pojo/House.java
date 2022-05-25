package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *  宅基地管理
 *
 */
@TableName("house_manage")
@Data
public class House {
    /**
     * 宅基地id
     */
    @TableId(type = IdType.AUTO)
    private int houseId;
    /**
     * 宅基地地址
     */
    private String houseAddress;
    /**
     * 宅基地拥有者
     */
    private String housePopulationId;
    /**
     * 宅基地申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date houseApplyTime;
    /**
     * 宅基地状态（0代表拥有 1申请中2未申请）
     */
    private String houseStatus;
    /**
     * 宅基地面积
     */
    private String houseArea;
    /**
     * 宅基地申请说明
     */
    private String houseDesc;
    /**
     * 宅基地所属村id
     */
    private int houseVillageId;
    @TableField(exist = false)
    private Village village;
    @TableField(exist = false)
    private Population population;
}
