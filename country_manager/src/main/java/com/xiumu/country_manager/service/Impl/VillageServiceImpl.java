package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.mapper.VillageMapper;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.pojo.Village;
import com.xiumu.country_manager.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageServiceImpl extends ServiceImpl<VillageMapper, Village> implements VillageService {

    @Autowired
    private VillageMapper villageMapper;
    @Override
    public PageInfo getAllVillage(Village village,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Village> allVillage = villageMapper.getAllVillage(village);
        PageInfo<Village> pageInfo=new PageInfo<>(allVillage);
        return pageInfo;
    }

    public List<Village> getVillageList(){
        return villageMapper.getVillageList();
    }//新加的lmy，改后
    @Override
    public List<Village> getAll(Village village){
        List<Village> allVillage = villageMapper.getAllVillage(village);
        return allVillage;
    }

    @Override
    public Village getVillageById(int id) {
        Village villageById = villageMapper.getVillageById(id);
        return villageById;
    }

    @Override
    public int addVillage(Village village) {
        return villageMapper.addVillage(village);
    }

    @Override
    public int deleteVillage(int id) {
        return villageMapper.deleteVillage(id);
    }

    @Override
    public int updateVillage(Village village) {
        return villageMapper.updateVillage(village);
    }

    @Override
    public Village selectByVillageNum(int villageNum) {
        return villageMapper.selectByNum(villageNum);
    }
}
