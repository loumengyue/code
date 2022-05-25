package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Role;

import java.util.List;


public interface RoleService extends IService<Role> {
    List<Role>  getAllRole();
}
