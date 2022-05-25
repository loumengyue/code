package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.*;
import com.xiumu.country_manager.service.OrganService;
import com.xiumu.country_manager.utils.Code;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机构
 */
@RestController
@CrossOrigin
public class OrganController {

    @Autowired
    private OrganService organService;

    @PostMapping("/getAllOrgan")
    public Result getAllOrgan(@RequestBody PageArgsPro<Organ> organPageArgsPro){
        Organ organ = organPageArgsPro.getCondition();
        int pageNum = organPageArgsPro.getPageNum();
        int pageSize = organPageArgsPro.getPageSize();
        PageInfo allOrgan = organService.getAllOrgan(organ,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allOrgan);
    }

    @PostMapping("/getOrganList")
    public Result getOrganList(){
        List<Organ> all =organService.getOrganList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getOrganListOK";
        res.put("flag",flag);
        res.put("organList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/4

    @PostMapping("/getOrganByName")
    public Result getOrganByName(@RequestBody Organ organ){
        List<Organ> byName = organService.getByName(organ);
        return ResultStatusUtil.JudgeStatus(byName);
    }

    @GetMapping("/getOrganById")
    public Result getOrganById(Integer id){
        Organ organById = organService.getOrganById(id);
        return ResultStatusUtil.JudgeStatus(organById);
    }
    @GetMapping("/deleteOrgan")
    public Result deleteOrgan(Integer id){
        int i = organService.deleteOrgan(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }
    @PostMapping("/addOrgan")
    public Result addOrgan(@RequestBody Organ organ){
        int i = organService.addOrgan(organ);
        return ResultStatusUtil.JudgeNum(i);
    }
    @PostMapping("/updateOrgan")
    public Result updateOrgan(@RequestBody Organ organ){
        int i = organService.updateOrgan(organ);
        return ResultStatusUtil.JudgeNum(i);
    }

}
