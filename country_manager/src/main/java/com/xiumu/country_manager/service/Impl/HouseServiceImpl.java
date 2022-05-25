package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.HouseMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.mapper.VillageMapper;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.House;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private PopulationMapper populationMapper;
    @Autowired
    private VillageMapper villageMapper;
    @Override
    public PageInfo getAllHouse(House house,int start, int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<House> allHouse = houseMapper.getAllHouse(house);
        PageInfo<House> pageInfo=new PageInfo(allHouse);
        return pageInfo;
    }
    @Override
    public PageInfo getMyAllHouse(House house,int pageNum,int pageSize,int id){
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<House> queryWrapper=new QueryWrapper<>();
        queryWrapper .eq("house_village_id",id)
                .like("house_address",house.getHouseAddress())
                .like("house_population_id",house.getHousePopulationId())
                .like("house_status",house.getHouseStatus());

        List<House> houseList=houseMapper.selectList(queryWrapper);


        List<House> houseList1=new ArrayList<>();
        for(House house1:houseList){
            House house2=house1;
            house2.setVillage(villageMapper.selectById(house1.getHouseVillageId()));
            //System.out.println("hhhhhooooooo反反复复发发发ooooooo"+ villageMapper.selectById(house1.getHouseVillageId()));

            QueryWrapper<Population> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("population_id",house1.getHousePopulationId());
            Population population=populationMapper.selectOne(queryWrapper1);
            //System.out.println("hhhhhoooooooooo水水水水水水oooo"+ population);
            house2.setPopulation(population);
           // System.out.println("hhhhhooohhh换行哈哈ooooooooooo"+ house2);
            houseList1.add(house2);
        }

        PageInfo<Population> pageInfo=new PageInfo(houseList);
        return pageInfo;
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
    public List<House> getMyHouseList(int id){
        List<House> all=houseMapper.getHouseByVillageId(id);
        return all;
    }
    @Override
    public List<House> getHouseList(){
        return houseMapper.getHouseList();
    }//新加的lmy，改后5/4

    @Override
    public House getHouseById(int id) {
        House houseById = houseMapper.getHouseById(id);
        return houseById;
    }

    @Override
    public int addHouse(House house) {
        return houseMapper.addHouse(house);
    }

    @Override
    public int deleteHouse(int id) {
        return houseMapper.deleteHouse(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateHouse(house);
    }
}
