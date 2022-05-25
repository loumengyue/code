package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ActivityMapper extends BaseMapper<Activity> {
    List<Activity> getAllActivity(Activity activity);
    Activity getActivityById(int id);
    int addActivity(Activity activity);
    int deleteActivity(int id);
    int updateActivity(Activity activity);

    /*@Select("Select * from activity_manage")*/
    List<Activity> getActivityList();//新加  lmy  5/4
}
