package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.House;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface HouseService extends IService<House> {
    /**
     * 查询所有
     * @return
     */
    PageInfo getAllHouse(House house,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    House getHouseById(int id);

    /**
     * 添加
     * @param house
     * @return
     */
    int addHouse(House house);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteHouse(int id);

    /**
     * 修改
     * @param house
     * @return
     */
    int updateHouse(House house);

    List<House> getHouseList();//新加的lmy，改后5/4

    /**
     *使用mybait plus，显示个人信息，有模糊查询
     */
    PageInfo getMyAllHouse(House house,int pageNum,int pageSize,int id);

    /**
     *使用xml文件，打印个人信息，没有模糊查询
     */
    List<House>getMyHouseList(int id);


}
