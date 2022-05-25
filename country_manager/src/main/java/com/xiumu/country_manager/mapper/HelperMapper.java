package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface HelperMapper extends BaseMapper<Helper> {
    List<Helper> getAllHelper(Helper helper);
    Helper getHelperById(int id);
    int addHelper(Helper helper);
    int deleteHelper(int id);
    int updateHelper(Helper helper);

    /*@Select("Select * from helper_manage")*/
    List<Helper> getHelperList();//新加的lmy，改后5/3
    List<Helper>getHelperByVillageId(int id);
}
