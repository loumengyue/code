package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.mapper.RoleMapper;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAllRole(){
        return roleMapper.getAllRole();
    }
}
