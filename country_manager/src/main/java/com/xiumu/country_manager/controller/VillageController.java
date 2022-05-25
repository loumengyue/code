package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Role;
import com.xiumu.country_manager.pojo.Village;
import com.xiumu.country_manager.service.VillageService;
import com.xiumu.country_manager.utils.Code;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  村委基本信息
 */
@RestController
@CrossOrigin
public class VillageController {
    @Autowired
    private VillageService villageService;

    @PostMapping("/getAllVillage")
    public Result getAllVillage(@RequestBody PageArgsPro<Village> villagePageArgsPro) {
        Village village = villagePageArgsPro.getCondition();
        int pageNum = villagePageArgsPro.getPageNum();
        int pageSize = villagePageArgsPro.getPageSize();
        PageInfo allVillage = villageService.getAllVillage(village,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allVillage);
    }
    @PostMapping("getAll")
    public Result getAll(@RequestBody Village village){
        List<Village> all = villageService.getAll(village);
        return ResultStatusUtil.JudgeStatus(all);
    }//原先大佬的

    @PostMapping("/getVillageList")
    public Result getVillageList(){
        List<Village> all = villageService.getVillageList();
        return ResultStatusUtil.JudgeStatus(all);
    }//新加的lmy，改后


    @GetMapping("/getVillageById")
    public Result getVillageById(Integer id) {
        Village villageById = villageService.getVillageById(id);
        return ResultStatusUtil.JudgeStatus(villageById);
    }

   /* @GetMapping("/getVillageById/{id}")
    public Result getVillageById(@PathVariable("id") Integer id) {
        Village villageById = villageService.getVillageById(id);
        return ResultStatusUtil.JudgeStatus(villageById);
    }*/

    @GetMapping("/deleteVillage")
    public Result deleteVillage(Integer id) {
        int i = villageService.deleteVillage(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }
   /* @GetMapping("/deleteVillage/{id}")
    public Result deleteVillage(@PathVariable("id") Integer id) {
        int i = villageService.deleteVillage(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }*/

    @PostMapping("/addVillage")
    public Result addVillage(@RequestBody Village village) {
        Village villageTemp = villageService.selectByVillageNum(village.getVillageNum());
        if (villageTemp != null){
            return new Result(Code.FAIL,"添加失败，该村委编号已存在！！");
        }
        int i = villageService.addVillage(village);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateVillage")
    public Result updateVillage(@RequestBody Village village) {
        int i = villageService.updateVillage(village);
        return ResultStatusUtil.JudgeNum(i);
    }
}
