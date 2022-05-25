package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Organ;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrganMapper extends BaseMapper<Organ> {

    List<Organ> getAllOrgan(Organ organ);
    Organ getOrganById(int id);
    Organ getOrganByName(String name);

    int addOrgan(Organ organ);
    int deleteOrgan(int id);
    int updateOrgan(Organ organ);

    /*@Select("Select * from organ_manage")*/
    /*select * from village_manage vm,organ_manage om where vm.village_id=om.organ_village_id*/
    /*@Select("select * from village_manage vm,organ_manage om where vm.village_id=om.organ_village_id")*/
    List<Organ>getOrganList();//新加  lmy  5/4

}
