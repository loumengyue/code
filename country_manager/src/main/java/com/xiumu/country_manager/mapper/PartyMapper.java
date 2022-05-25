package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Organ;
import com.xiumu.country_manager.pojo.Party;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PartyMapper extends BaseMapper<Party> {
    List<Party> getAllParty(Party party);
    Party getPartyById(int id);
    int addParty(Party party);
    int deleteParty(int id);
    int updateParty(Party party);

    @Select("Select * from party_manage")
    List<Party>getPartyList();//新加  lmy  5/4
}
