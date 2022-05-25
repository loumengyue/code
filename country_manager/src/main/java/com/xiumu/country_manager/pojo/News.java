package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *   消息管理 发布通告
 *
 */
@TableName("news_manage")
@Data
public class News {
    /**
     * 通告id
     */

    @TableId(type = IdType.AUTO)
    private int newId;


    /**
     * 通告表标题
     */
    private String newTitle;
    /**
     * 通告内容
     */
    private String newContent;
    /**
     * 通告发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newTime;
    /**
     * 发布人
     */
    private String newPerson;
    /**
     * 通知是否置顶（0不置顶1置顶）
     */
    private int newPriority;

}
