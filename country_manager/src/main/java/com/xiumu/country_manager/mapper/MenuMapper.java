package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Menu;
import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 动态菜单导航栏 新加的lmy
 *
 */

@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
   /* List<Menu> getAllMenu(Menu menu);*/

    /*Select * from menu_manage*/
    List<Menu> getAllMenu();

    /*Select * from menu_manage where menu_role_id=1;*/
    /* @Select("Select * from menu_manage where menu_role_id=#{menuRoleId}")*/
    List<Menu> getMenuByRoleId(int menuRoleId);
    List<Menu> getMenuByType(int menuType);
    List<Menu> getMenuByList(int menuList);

}
