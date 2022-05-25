package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 *  村委信息管理-村委基础信息
 *
 */
@TableName("village_manage")
@Data
public class Village {
    /**
     * 村委id
     */
    @TableId(type = IdType.AUTO)
    private int villageId;
    /**
     * 村委编号
     */
    private int villageNum;
    /**
     * 村委名称
     */
    private String villageName;
    /**
     * 村委地址
     */
    private String villageAddress;
    /**
     * 村委负责人
     */
    private String villageLeading;
    /**
     * 村委负责人电话
     */
    private String villagePhone;

}
