package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface ActivityService extends IService<Activity> {

    /**
     * 查询所有
     * @return
     */
    PageInfo getAllActivity(Activity activity,int pageNum,int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    Activity getActivityById(int id);

    /**
     * 添加
     * @param activity
     * @return
     */
    int addActivity(Activity activity);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteActivity(int id);

    /**
     * 修改
     * @param activity
     * @return
     */
    int updateActivity(Activity activity);

    List<Activity> getActivityList();//新加  lmy  5/4

}
