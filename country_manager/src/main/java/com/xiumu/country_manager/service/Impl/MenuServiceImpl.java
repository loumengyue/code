package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.MenuMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.Menu;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 动态菜单导航栏 新加的lmy
 *
 */

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }
    @Override
    public List<Menu> getMenuByRoleId(int menuRoleId) {
        return menuMapper.getMenuByRoleId(menuRoleId);
    }

    @Override
    public List<Menu> getMenuByType(int menuType) {
        return menuMapper.getMenuByRoleId(menuType);
    }

    @Override
    public List<Menu> getMenuByList(int menuList) {
        return menuMapper.getMenuByRoleId(menuList);
    }
}












