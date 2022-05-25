package com.xiumu.country_manager.controller;

import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.pojo.Village;
import com.xiumu.country_manager.service.RoleService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *角色
 */
@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/getAllRole")
    public Result getAllRole(){
        List<Role> all = roleService.getAllRole();
        return ResultStatusUtil.JudgeStatus(all);
    }
}
