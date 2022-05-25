package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.PartyMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.Party;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {
    @Autowired
    private PartyMapper partyMapper;
    @Override
    public PageInfo getAllParty(Party party,int start, int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<Party> allParty = partyMapper.getAllParty(party);
        PageInfo<Party> pageInfo=new PageInfo(allParty);
        return pageInfo;
    }
    @Override
    public List<Party> getPartyList(){  //新加  lmy  5/4
        return partyMapper.getPartyList();
    }

    @Override
    public Party getPartyById(int id) {
        Party partyById = partyMapper.getPartyById(id);
        return partyById;
    }

    @Override
    public int addParty(Party party) {
        return partyMapper.addParty(party);
    }

    @Override
    public int deleteParty(int id) {
        return partyMapper.deleteParty(id);
    }

    @Override
    public int updateParty(Party party) {
        return partyMapper.updateParty(party);
    }
}
