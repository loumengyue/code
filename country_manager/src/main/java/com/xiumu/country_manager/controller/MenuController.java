package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Menu;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.service.MenuService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 动态菜单导航栏 新加的lmy
 *
 */

@RestController
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/getAllMenuByRoleId/{id}")
    public Result getAllMenuByRoleId(@PathVariable("id") Integer menuByRoleId){
        List<Menu> all = menuService.getMenuByRoleId(menuByRoleId);
        return ResultStatusUtil.JudgeStatus(all);
    }//新加的lmy，简洁

    @PostMapping("/getAllMenu")
    public Result getAllMenu(){
        List<Menu> all = menuService.getAllMenu();
        return ResultStatusUtil.JudgeStatus(all);
    }//新加的lmy，打印所有

    @GetMapping("/getAllMenusByRoleId/{id}")
    public Result getAllMenusByRoleId(@PathVariable("id") Integer menuByRoleId){
        System.out.println("访问成功！");
        HashMap<String,Object> data=new HashMap<>();
        List<Menu> menus = menuService.getMenuByRoleId(menuByRoleId);
        if(menus!=null){
            data.put("menus",menus);
            data.put("flag","GetMenuSuccess");                          //success 200
        }else {
            data.put("flag","GetMenuError");                       //error 404
        }
        return ResultStatusUtil.JudgeStatus(data);
    }//新加的lmy，正式的按照id查询打印



}
