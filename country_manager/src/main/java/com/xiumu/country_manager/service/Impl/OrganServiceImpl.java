package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.OrganMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.Organ;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganServiceImpl extends ServiceImpl<OrganMapper, Organ> implements OrganService {

    @Autowired
    private OrganMapper organMapper;

    @Override
    public PageInfo getAllOrgan(Organ organ,int start,int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<Organ> allOrgan = organMapper.getAllOrgan(organ);
        PageInfo<Organ> pageInfo=new PageInfo(allOrgan);
        return pageInfo;
    }

    @Override
    public  List<Organ>getOrganList(){    //新加  lmy  5/4
        return organMapper.getOrganList();
    }
    @Override
    public Organ getOrganById(int id) {
        Organ organById = organMapper.getOrganById(id);
        return organById;
    }

    @Override
    public Organ getOrganByName(String name) {
        return  organMapper.getOrganByName(name);
    }

    @Override
    public int addOrgan(Organ organ) {
        return organMapper.addOrgan(organ);
    }

    @Override
    public int deleteOrgan(int id) {
        return organMapper.deleteOrgan(id);
    }

    @Override
    public int updateOrgan(Organ organ) {
        return organMapper.updateOrgan(organ);
    }

    @Override
    public List<Organ> getByName(Organ organ) {
        List<Organ> organList = organMapper.getAllOrgan(organ);
        return organList;
    }
}
