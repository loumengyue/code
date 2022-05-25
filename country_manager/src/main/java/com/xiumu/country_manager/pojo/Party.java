package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *  党建管理-党组织基础信息
 *
 */
@TableName("party_manage")
@Data
public class Party {

    /**
     * 党组织编号
     */
    @TableId(type = IdType.AUTO)
    private int partyId;
    /**
     * 党组织名称
     */
    private String partyName;
    /**
     * 党组织成立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date partyStartTime;

    /**
     * 所属党组织
     */
    private int parentParty;


}
