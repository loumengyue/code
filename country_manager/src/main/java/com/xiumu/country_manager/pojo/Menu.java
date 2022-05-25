package com.xiumu.country_manager.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 动态菜单导航栏 新加的lmy
 *
 */
@TableName("menu_manage")
@Data
public class Menu {

    /**
     * 菜单编号
     */
    @TableId(type = IdType.AUTO)
    private int menuId;
    /**
     * 菜单导航名称
     */
    private String menuName;
    /**
     * 菜单导航拥有的角色id
     */
    private int menuRoleId;
    /**
     * 导航路径
     */
    private String menuPath;
    /**
     * 菜单类型 ：一级菜单 1  二级菜单 2
     */
    private int menuType;
    /**
     * 菜单分级部署
     */
    private int menuList;
    private Role role;

}
