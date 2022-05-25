package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Member;
import com.xiumu.country_manager.pojo.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper extends BaseMapper<Member> {
    List<Member> getAllMember(Member member);
    Member getMemberById(int id);
    int addMember(Member member);
    int deleteMember(int id);
    int updateMember(Member member);

    /*@Select("Select * from member_manage")*/
    List<Member> getMemberList();//新加  lmy  5/4
}
