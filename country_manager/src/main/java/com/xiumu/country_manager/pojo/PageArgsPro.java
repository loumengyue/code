package com.xiumu.country_manager.pojo;

import lombok.Data;

/**
 * 分页查询处理
 *
 */
@Data
public class PageArgsPro<T> {
    /**
     * 查询需要得实体类
     */
    private T condition;
    /**
     * 分页数据
     */
    private int pageNum;
    private int pageSize;
}
