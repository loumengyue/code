package com.xiumu.country_manager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *   文件实体类
 *
 */
@Data
@TableName("file_manage")
public class Papers {

    /**
     * 文件id
     */
    @TableId
    private int fileId;
    /**
     * 文件名字
     */
    private String fileName;
    /**
     * 绝对路径
     */
    private String fileRoute;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件简介
     */
    private String fileBrief;
    /**
     * 文件上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "Asia/Shanghai")//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fileUpTime;

}
