package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Member;
import com.xiumu.country_manager.pojo.Population;

import java.util.List;

public interface MemberService extends IService<Member> {
    /**
     * 查询所有
     * @return
     */
    PageInfo getAllMember(Member member,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    Member getMemberById(int id);

    /**
     * 添加
     * @param member
     * @return
     */
    int addMember(Member member);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteMember(int id);

    /**
     * 修改
     * @param member
     * @return
     */
    int updateMember(Member member);

    List<Member> getMemberList();//新加  lmy  5/4

}
