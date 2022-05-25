package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Party;
import com.xiumu.country_manager.service.PartyService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *党建管理-党组织基础信息
 */
@RestController
@CrossOrigin
public class PartyController {
    @Autowired
    private PartyService partyService;

    @PostMapping("/getAllParty")
    public Result getAllParty(@RequestBody PageArgsPro<Party> partyPageArgsPro) {
        Party party = partyPageArgsPro.getCondition();
        int pageNum = partyPageArgsPro.getPageNum();
        int pageSize = partyPageArgsPro.getPageSize();
        PageInfo allParty = partyService.getAllParty(party,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allParty);
    }

    @PostMapping("/getPartyList")
    public Result getPartyList(){
        List<Party> all =partyService.getPartyList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getPartyListOK";
        res.put("flag",flag);
        res.put("partyList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/4
    @GetMapping("/getPartyById")
    public Result getPartyById(Integer id) {
        Party partyById = partyService.getPartyById(id);
        return ResultStatusUtil.JudgeStatus(partyById);
    }

    @GetMapping("/deleteParty")
    public Result deleteParty(Integer id) {
        int i = partyService.deleteParty(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addParty")
    public Result addParty(@RequestBody Party party) {
        int i = partyService.addParty(party);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateParty")
    public Result updateParty(@RequestBody Party party) {
        int i = partyService.updateParty(party);
        return ResultStatusUtil.JudgeNum(i);
    }
}
