package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.HelperMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.mapper.VillageMapper;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.House;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelperServiceImpl extends ServiceImpl<HelperMapper, Helper> implements HelperService {
    @Autowired
    private HelperMapper helperMapper;
    @Autowired
    private PopulationMapper populationMapper;
    @Autowired
    private VillageMapper villageMapper;

    @Override
    public PageInfo getAllHelper(Helper helper,int start, int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<Helper> allHelper = helperMapper.getAllHelper(helper);
        PageInfo<Helper> pageInfo=new PageInfo(allHelper);
        return pageInfo;
    }
    @Override
    public PageInfo getMyAllHelper(Helper helper , int pageNum, int pageSize, int id){
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Helper> queryWrapper=new QueryWrapper<>();
        queryWrapper .eq("helper_village_id",id)
                .like("helper_population_id",helper.getHelperPopulationId())
                .like("helper_type",helper.getHelperType());
                //.like("helper_status",helper.getHelperStatus());
        List<Helper> helperList = helperMapper.selectList(queryWrapper);

        List<Helper> helperList1=new ArrayList<>();
        for(Helper helper1:helperList){
           // helper1.setVillage(villageMapper.selectById(helper1.getHelperVillageId()));
           //helper1.setPopulation(populationMapper.selectById(helper1.getHelperPopulationId()));
            //helperList1.add(helper1);

            Helper helper2=helper1;
            helper2.setVillage(villageMapper.selectById(helper1.getHelperVillageId()));
            QueryWrapper<Population> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("population_id",helper1.getHelperPopulationId());
            Population population=populationMapper.selectOne(queryWrapper1);
            helper2.setPopulation(population);
            helperList1.add(helper2);
        }
        PageInfo<Helper> pageInfo=new PageInfo(helperList);
        return pageInfo;
    }
    @Override
    public List<Helper> getMyHelperList(int id){
       //List<Helper> helperList=helperMapper.getHelperByVillageId(id);
        // return helperList;

        QueryWrapper<Helper> queryWrapper=new QueryWrapper<>();
        queryWrapper .eq("helper_village_id",id);
        List<Helper> helperList = helperMapper.selectList(queryWrapper);
        List<Helper> helperList1=new ArrayList<>();
        for(Helper helper1:helperList){
            Helper helper2=helper1;
            helper2.setVillage(villageMapper.selectById(helper1.getHelperVillageId()));
            QueryWrapper<Population> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("population_id",helper1.getHelperPopulationId());
            Population population=populationMapper.selectOne(queryWrapper1);
            helper2.setPopulation(population);
            helperList1.add(helper2);
        }
        return helperList;
    }
    @Override
    public  List<Helper> getHelperList(){
        return helperMapper.getHelperList();
    }//新加的lmy，改后5/3

    @Override
    public Helper getHelperById(int id) {
        Helper helperById = helperMapper.getHelperById(id);
        return helperById;
    }

   /* @Override
    public int addHelper(Helper helper) {
        QueryWrapper<Population> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("population_id",helper.getHelperPopulationId());
        Population population = populationMapper.selectOne(queryWrapper);
        int populationVillageId = population.getPopulationVillageId();
        helper.setHelperVillageId(populationVillageId);
        return helperMapper.addHelper(helper);
    }*///原有
   @Override
   public int addHelper(Helper helper) {
       return helperMapper.addHelper(helper);
   }

    @Override
    public int deleteHelper(int id) {
        return helperMapper.deleteHelper(id);
    }

    @Override
    public int updateHelper(Helper helper) {
        return helperMapper.updateHelper(helper);
    }
}
