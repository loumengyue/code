package com.xiumu.country_manager.utils;

import lombok.Data;

/**
 * @author: 岐神~汤圆
 * @Description:
 * @Attention:
 * @date: 2021/3/17 12:54
 * @version:1.0
 */
@Data
public  class FileResult {
    /**
     * 返回的状态
     */
    public  Code code;

    /**
     * 返回文件上传的绝路路径
     */
    public  String fileUrl;

}
