package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Party;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface PartyService extends IService<Party> {
    /**
     * 查询所有
     * @return
     */
    PageInfo getAllParty(Party party,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    Party getPartyById(int id);

    /**
     * 添加
     * @param party
     * @return
     */
    int addParty(Party party);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteParty(int id);

    /**
     * 修改
     * @param party
     * @return
     */
    int updateParty(Party party);

    List<Party> getPartyList();//新加  lmy  5/4

}
