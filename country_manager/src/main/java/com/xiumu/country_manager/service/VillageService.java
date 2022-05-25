package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.pojo.Village;

import java.util.List;


public interface  VillageService extends IService<Village> {
    /**
     * 查询所有村委
     * @return
     */
    PageInfo getAllVillage(Village village,int start, int pageSize);
    /**
     * 查看所有村委 不分页的
     */
    List<Village> getVillageList();//新加的lmy
    List<Village> getAll(Village village);

    /**
     * 根据村委id获取指定村委
     * @param id
     * @return
     */
    Village getVillageById(int id);

    /**
     * 添加
     * @param village
     * @return
     */
    int addVillage(Village village);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteVillage(int id);

    /**
     * 修改
     * @param village
     * @return
     */
    int updateVillage(Village village);

    /**
     * 根据村委编号查询
     * @param villageNum 村委编号
     * @return
     */
    Village selectByVillageNum(int villageNum);

}
