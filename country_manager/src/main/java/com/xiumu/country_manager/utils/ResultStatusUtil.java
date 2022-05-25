package com.xiumu.country_manager.utils;

/**
 *返回状态判断   Result
 */
public class ResultStatusUtil {
    public static Result JudgeStatus(Object o){
        Result result=new Result();
        if(o!=null){
            result.setCode(Code.SUCCESS);
            result.setMessage("成功");
            result.setData(o);
        }else{
            result.setCode(Code.FAIL);
            result.setMessage("执行失败");
        }
        return result;
    }

    public static Result JudgeNum(int i){
        Result result=new Result();
        if(i>0){
            //删除成功了
            result.setCode(Code.SUCCESS);
            result.setMessage("成功");
        }else{
            result.setCode(Code.FAIL);
            result.setMessage("执行失败");
        }
        return result;
    }
}
