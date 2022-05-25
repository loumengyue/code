package com.xiumu.country_manager.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.HelperService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帮扶对象管理
 */
@RestController
@CrossOrigin
public class HelperController {
    @Autowired
    private HelperService helperService;

   /* //分页查询
    @GetMapping("/findHelperAll/{page}/{size}")
    public Page<Helper> findHelperAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return dogRepository.findAll(pageable);
    }*/

    @PostMapping("/getAllHelper")
    public Result getAllHelper(@RequestBody PageArgsPro<Helper> helperPageArgsPro) {
        Helper helper = helperPageArgsPro.getCondition();
        int pageNum = helperPageArgsPro.getPageNum();
        int pageSize = helperPageArgsPro.getPageSize();
        PageInfo allHelper = helperService.getAllHelper(helper,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allHelper);
    }
    @PostMapping("/getMyAllHelper")
    public Result getMyAllHelper(@RequestBody PageArgsPro<Helper> helperPageArgsPro) {
        Helper helper = helperPageArgsPro.getCondition();
        int id=helper.getHelperVillageId();
        int pageNum = helperPageArgsPro.getPageNum();
        int pageSize = helperPageArgsPro.getPageSize();
        PageInfo allHelper = helperService.getMyAllHelper(helper,pageNum,pageSize,id);
        return ResultStatusUtil.JudgeStatus(allHelper);

    }

    @PostMapping("/getMyHelperList")
    public Result getMyHelperList(Integer id){
        List<Helper> all =helperService.getMyHelperList(id);
        return ResultStatusUtil.JudgeStatus(all);
    }

    @PostMapping("/getHelperList")
    public Result getHelperList(){
        List<Helper> all = helperService.getHelperList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getHelperListOK";
        res.put("flag",flag);
        res.put("helperList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/3

    @GetMapping("/getHelperById")
    public Result getHelperById(Integer id) {
        Helper helperById = helperService.getHelperById(id);
        return ResultStatusUtil.JudgeStatus(helperById);
    }
    @GetMapping("/deleteHelper")
    public Result deleteHelper(Integer id) {
        int i = helperService.deleteHelper(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addHelper")
    public Result addHelper(@RequestBody Helper helper) {
        int i = helperService.addHelper(helper);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateHelper")
    public Result updateHelper(@RequestBody Helper helper) {
        int i = helperService.updateHelper(helper);
        return ResultStatusUtil.JudgeNum(i);
    }
}
