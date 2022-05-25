package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.controller.UserController;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.mapper.VillageMapper;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopulationServiceImpl extends ServiceImpl<PopulationMapper, Population> implements PopulationService {

    @Autowired
    private PopulationMapper populationMapper;
    @Autowired
    private VillageMapper villageMapper;
    @Autowired
    private UserController userController;
    @Override
    public PageInfo getAllPopulation(Population population, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Population> allPopulation = populationMapper.getAllPopulation(population);
        PageInfo<Population> pageInfo=new PageInfo(allPopulation);
        return pageInfo;
    }
    /*@Override
    public PageInfo getMyAllPopulation(Population population, int pageNum, int pageSize,int id) {
        PageHelper.startPage(pageNum,pageSize);
        List<Population> myAllPopulation=populationMapper.getPopulationByVillageId(id);
        PageInfo<Population> pageInfo=new PageInfo(myAllPopulation);
        return pageInfo;
    }*///使用xml文件，显示个人村庄信息，但没有模糊查询
    @Override
    public PageInfo getMyAllPopulation(Population population, int pageNum, int pageSize,int id) {
        PageHelper.startPage(pageNum,pageSize);
        //System.out.println(population+"hhahhahah哈哈哈哈哈");
        QueryWrapper<Population> queryWrapper=new QueryWrapper<>();
           /* queryWrapper .eq("population_village_id",id)
                    .and(i->(i.like("population_id",population.getPopulationId()))
                    .or().like("population_name",population.getPopulationName()));*/
        queryWrapper .eq("population_village_id",id)
               .like("population_id",population.getPopulationId())
                .like("population_name",population.getPopulationName());
        List<Population> populationList = populationMapper.selectList(queryWrapper);

        List<Population> populationList1=new ArrayList<>();

        for(Population population1:populationList){
            Population population2=population1;
            //System.out.println(villageMapper.selectById(population1.getPopulationVillageId())+"哈哈哈你呢");
            //System.out.println(population1.getPopulationVillageId()+"哈哈哈你呢");
            population2.setVillage(villageMapper.selectById(population1.getPopulationVillageId()));
            populationList1.add(population2);
        }
        System.out.println(populationList1);
        PageInfo<Population> pageInfo=new PageInfo(populationList);
        return pageInfo;
    }

    @Override
    public List<Population> getMyPopulationList(int id)
    {
        //System.out.println(id+"哈哈哈呼吁好好补补不不不999999999iiiiii你呢");
        List<Population> all=populationMapper.getPopulationByVillageId(id);
       // System.out.println(all+"哈吁好好补补不不不999999999");
        return all;
    }
    
    @Override
    public List<Population>getPopulationByName(String name){
        List<Population>getAllPopulationByName=populationMapper.getPopulationByName(name);
        return getAllPopulationByName;
    }
    @Override
    public List<Population> getPopulationList(){
        return populationMapper.getPopulationList();//新加的lmy，改后5/4
    }
    @Override
    public Population getPopulationById(int id) {
        Population populationById = populationMapper.getPopulationById(id);
        return populationById;
    }
    @Override
    public int addPopulation(Population population) {
        return populationMapper.addPopulation(population);
    }
    @Override
    public int deletePopulation(int id) {
        return populationMapper.deletePopulation(id);
    }

    @Override
    public int updatePopulation(Population population) {
        return populationMapper.updatePopulation(population);
    }


}

