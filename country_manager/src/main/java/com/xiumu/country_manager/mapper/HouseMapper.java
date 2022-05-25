package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.House;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HouseMapper extends BaseMapper<House> {
    List<House> getAllHouse(House house);
    House getHouseById(int id);
    int addHouse(House house);
    int deleteHouse(int id);
    int updateHouse(House house);

   /* @Select("Select * from house_manage")*/
    List<House> getHouseList();//新加的lmy，改后5/4

    List<House>getHouseByVillageId(int id);
}
