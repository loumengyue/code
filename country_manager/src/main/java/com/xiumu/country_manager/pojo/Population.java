package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *   常住人口管理-lmy
 */

@TableName("population_manage")
@Data
public class Population {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private int id;
    /**
     * 人口编号
     */
    private String populationId;
    /**
     * 人口姓名
     */
    private String populationName;
    /**
     * 人口年龄
     */
    private int populationAge;
    /**
     * 人口所在地
     */
    private String populationAddress;
    /**
     * 人口类型(0属于本地1属于外地)
     */
    private int populationType;
    /**
     * 本地人口类型（0是常住1是外出）
     */
    private int populationLocalType;
    /**
     * 人口所属村委
     */
    private int populationVillageId;
    @TableField(exist = false)
    private Village village;//lmy新加--5/8
}
