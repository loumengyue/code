package com.xiumu.country_manager.utils;

import lombok.Data;

import java.util.Map;

/**
 * 返回的结果封装  Result
 */
@Data
public class  Result {
    /**
     * 返回的状态
     */
    public  Code code;
    /**
     * 返回的结果信息
     */
    public  String message;

    /**
     * 返回的数据
     */
    public Object data;

    public Result() {
    }

    public Result(Code code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Code code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
