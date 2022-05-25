package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface HelperService extends IService<Helper> {
    /**
     * 查询所有
     * @return
     */
    PageInfo getAllHelper(Helper helper,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    Helper getHelperById(int id);

    /**
     * 添加
     * @param helper
     * @return
     */
    int addHelper(Helper helper);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteHelper(int id);

    /**
     * 修改
     * @param helper
     * @return
     */
    int updateHelper(Helper helper);

    /**
     *
     * 使用xml文件，打印全部信息，没有模糊查询
     */
    List<Helper> getHelperList();//新加的lmy，改后5/3

    /**
     *
     *使用mybait plus，显示个人信息，有模糊查询
     */
    PageInfo getMyAllHelper(Helper helper , int pageNum, int pageSize, int id);
    /**
     *使用xml文件，打印个人信息，没有模糊查询
     */
    List<Helper> getMyHelperList(int id);

}
