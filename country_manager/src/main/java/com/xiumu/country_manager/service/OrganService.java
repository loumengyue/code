package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Organ;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface OrganService extends IService<Organ> {

    /**
     * 查询所有
     * @return
     */
    PageInfo getAllOrgan(Organ organ,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    Organ getOrganById(int id);

    Organ getOrganByName(String name);

    /**
     * 添加
     * @param organ
     * @return
     */
    int addOrgan(Organ organ);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteOrgan(int id);

    /**
     * 修改
     * @param organ
     * @return
     */
    int updateOrgan(Organ organ);


    List<Organ> getByName(Organ organ);

    List<Organ>getOrganList();//新加  lmy  5/4
}
