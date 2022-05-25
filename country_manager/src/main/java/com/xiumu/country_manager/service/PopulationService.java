package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;


public interface PopulationService extends IService<Population> {
    /**
     *使用xml文件，显示全部村庄信息，有模糊查询
     */
    PageInfo getAllPopulation(Population population,int pageNum,int pageSize);
    Population getPopulationById(int id);
    int addPopulation(Population population);
    int deletePopulation(int id);
    int updatePopulation(Population population);
    List<Population>getPopulationByName(String name);

    /**
     *使用xml文件，打印全部信息，没有模糊查询
     */
    List<Population> getPopulationList();

    /**
     *使用mybait plus，显示个人信息，有模糊查询
     */
    PageInfo getMyAllPopulation(Population population,int pageNum,int pageSize,int id);

    /**
     *使用xml文件，打印个人信息，没有模糊查询
     */
    List<Population> getMyPopulationList(int id);


}//lmy新加--5/8