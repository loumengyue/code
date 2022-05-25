package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Menu;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

/**
 * 动态菜单导航栏 新加的lmy
 *
 */

public interface MenuService extends IService<Menu> {
    List<Menu> getAllMenu();
    List<Menu> getMenuByRoleId(int menuRoleId);
    List<Menu> getMenuByType(int menuType);
    List<Menu> getMenuByList(int menuList);
}
