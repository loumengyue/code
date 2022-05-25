package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.MemberMapper;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.pojo.Member;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public PageInfo getAllMember(Member member,int start, int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<Member> allMember = memberMapper.getAllMember(member);
        PageInfo<Member> pageInfo=new PageInfo(allMember);
        return pageInfo;
    }

    @Override
    public List<Member> getMemberList(){
        return memberMapper.getMemberList();
    }//新加  lmy  5/4
    @Override
    public Member getMemberById(int id) {
        Member memberById = memberMapper.getMemberById(id);
        return memberById;
    }

    @Override
    public int addMember(Member member) {
        return memberMapper.addMember(member);
    }

    @Override
    public int deleteMember(int id) {
        return memberMapper.deleteMember(id);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }
}
