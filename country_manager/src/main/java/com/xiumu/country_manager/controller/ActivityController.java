package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.service.ActivityService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动
 */
@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/getAllActivity")
    public Result getAllActivity(@RequestBody PageArgsPro<Activity> activityPageArgsPro) {
        Activity activity=activityPageArgsPro.getCondition();
        int pageNum=activityPageArgsPro.getPageNum();
        int pageSize = activityPageArgsPro.getPageSize();
        PageInfo allActivity = activityService.getAllActivity(activity,pageNum,pageSize);
        return ResultStatusUtil.JudgeStatus(allActivity);
    }

    @PostMapping("/getActivityList")
    public Result getActivityList(){
        List<Activity> all =activityService.getActivityList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getActivityListOK";
        res.put("flag",flag);
        res.put("activityList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/4

    @GetMapping("/getActivityById")
    public Result getActivityById(Integer id) {
        Activity activityById = activityService.getActivityById(id);
        return ResultStatusUtil.JudgeStatus(activityById);
    }

    @GetMapping("/deleteActivity")
    public Result deleteActivity(Integer id) {
        int i = activityService.deleteActivity(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addActivity")
    public Result addActivity(@RequestBody Activity activity) {
        int i = activityService.addActivity(activity);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateActivity")
    public Result updateActivity(@RequestBody Activity activity) {
        int i = activityService.updateActivity(activity);
        return ResultStatusUtil.JudgeNum(i);
    }
}
