package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Population;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
/*
public interface PopulationMapper extends BaseMapper<Population> {
}
*///原来版本
public interface PopulationMapper extends BaseMapper<Population> {

    List<Population>getAllPopulation(Population population);
    Population getPopulationById(int id);
    int addPopulation(Population population);
    int deletePopulation(int id);
    int updatePopulation(Population population);
    List<Population> getPopulationList();            //避开分页做全局导出excel

    List<Population>getPopulationByName(String name);
    List<Population>getPopulationByVillageId(int id);
    Population getPopulationByPopulationId(String populationId);



}//新加  lmy  5/8