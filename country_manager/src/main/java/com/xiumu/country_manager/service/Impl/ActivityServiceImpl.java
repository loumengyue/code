package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.ActivityMapper;
import com.xiumu.country_manager.mapper.OrganMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Organ;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.ActivityService;
import com.xiumu.country_manager.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private OrganMapper organMapper;
    @Override
    public PageInfo getAllActivity(Activity activity,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Activity> allActivity = activityMapper.getAllActivity(activity);
        PageInfo<Activity> pageInfo=new PageInfo(allActivity);
        return pageInfo;
    }
    @Override
    public List<Activity> getActivityList(){
        return activityMapper.getActivityList();//新加的lmy，改后5/4
    }

    @Override
    public Activity getActivityById(int id) {
        Activity activityById = activityMapper.getActivityById(id);
        return activityById;
    }

    @Override
    public int addActivity(Activity activity) {
        return activityMapper.addActivity(activity);
    }

    @Override
    public int deleteActivity(int id) {
        return activityMapper.deleteActivity(id);
    }

    @Override
    public int updateActivity(Activity activity) {
        return activityMapper.updateActivity(activity);
    }
}
