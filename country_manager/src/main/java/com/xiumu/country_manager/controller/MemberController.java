package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Member;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.service.MemberService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 党建管理-党员信息
 */
@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/getAllMember")
    public Result getAllMember(@RequestBody PageArgsPro<Member> memberPageArgsPro) {
        Member member = memberPageArgsPro.getCondition();
        int pageNum = memberPageArgsPro.getPageNum();
        int pageSize = memberPageArgsPro.getPageSize();
        PageInfo allMember = memberService.getAllMember(member,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allMember);
    }
    @PostMapping("/getMemberList")
    public Result getMemberList(){
        List<Member> all =memberService.getMemberList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getMemberListOK";
        res.put("flag",flag);
        res.put("memberList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/4

    @GetMapping("/getMemberById")
    public Result getMemberById(Integer id) {
        Member memberById = memberService.getMemberById(id);
        return ResultStatusUtil.JudgeStatus(memberById);
    }

    @GetMapping("/deleteMember")
    public Result deleteMember(Integer id) {
        int i = memberService.deleteMember(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addMember")
    public Result addMember(@RequestBody Member member) {
        int i = memberService.addMember(member);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateMember")
    public Result updateMember(@RequestBody Member member) {
        int i = memberService.updateMember(member);
        return ResultStatusUtil.JudgeNum(i);
    }
}
