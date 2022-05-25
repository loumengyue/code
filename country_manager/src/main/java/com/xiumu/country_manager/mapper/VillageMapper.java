package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface VillageMapper  extends BaseMapper<Village> {

    List<Village> getAllVillage(Village village);
    @Select("select * from village_manage where village_num=#{id}")
    Village getVillageById(int id);
    @Insert("insert into  village_manage (village_num,village_name,village_address,village_leading,village_phone) values(#{villageNum},#{villageName},#{villageAddress},#{villageLeading},#{villagePhone})")
    int addVillage(Village village);
    @Delete("delete from village_manage where village_id=#{id}")
    int deleteVillage(int id);
    @Update("update village_manage set village_name=#{villageName},village_address=#{villageAddress},village_leading=#{villageLeading},village_phone=#{villagePhone} where village_id=#{villageId}")
    int updateVillage(Village village);

    @Select("select * from village_manage where village_num=#{num}")
    Village selectByNum(int num);

    @Select("select * from village_manage")
    List<Village> getVillageList();//新加的lmy
}
