package com.xiumu.country_manager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Activity;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.service.PopulationService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常住人口
 */
@RestController
@CrossOrigin
public class PopulationController {

    @Autowired
    private PopulationService populationService;

   /* @PostMapping("/getAllPopulation")
    public Result getAllPopulation(@RequestBody PageArgsPro<Population> populationPageArgsPro) {
        Population population = populationPageArgsPro.getCondition();
        int pageNum = populationPageArgsPro.getPageNum();
        int pageSize = populationPageArgsPro.getPageSize();
        Page<Population> allPopulation = populationService.getAllPopulation(population, pageNum, pageSize);

        return ResultStatusUtil.JudgeStatus(allPopulation);

    }*///原有的部分
   @PostMapping("/getAllPopulation")
   public Result getAllPopulation(@RequestBody PageArgsPro<Population> populationPageArgsPro) {
       Population population = populationPageArgsPro.getCondition();
       int pageNum = populationPageArgsPro.getPageNum();
       int pageSize = populationPageArgsPro.getPageSize();
       PageInfo allPopulation=populationService.getAllPopulation(population,pageNum,pageSize);
       return ResultStatusUtil.JudgeStatus(allPopulation);

   }
    @PostMapping("/getMyAllPopulation")
    public Result getMyAllPopulation(@RequestBody PageArgsPro<Population> populationPageArgsPro) {
        Population population = populationPageArgsPro.getCondition();
        //System.out.println("哈哈哈哈哈："+population.getPopulationVillageId());
        int id=population.getPopulationVillageId();
        //System.out.println("呵呵呵呵呵呵额："+id);
        int pageNum = populationPageArgsPro.getPageNum();
        int pageSize = populationPageArgsPro.getPageSize();
        PageInfo allPopulation=populationService.getMyAllPopulation(population,pageNum,pageSize,id);
        return ResultStatusUtil.JudgeStatus(allPopulation);

    }

    @PostMapping("/getMyPopulationList")
    public Result getMyPopulationList(Integer id){
        //System.out.println("哈哈哈哈哈打印一下低："+id);
        List<Population> all =populationService.getMyPopulationList(id);
        return ResultStatusUtil.JudgeStatus(all);
    }

    @PostMapping("/getPopulationList")
    public Result getPopulationList(){
        List<Population> all =populationService.getPopulationList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getPopulationListOK";
        res.put("flag",flag);
        res.put("populationList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/4


    @GetMapping("/getPopulationById")
    public Result getPopulationById(Integer id) {
        Population population = populationService.getPopulationById(id);
        return ResultStatusUtil.JudgeStatus(population);
    }

    @GetMapping("/getPopulationByName")
    public Result getPopulationByName(String name){
        List<Population> byName = populationService.getPopulationByName(name);
        return ResultStatusUtil.JudgeStatus(byName);
    }

    @GetMapping("/deletePopulation")
    public Result deletePopulation(Integer id) {
        int i = populationService.deletePopulation(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);

    }

    @PostMapping("/addPopulation")
    public Result addPopulation(@RequestBody Population population) {
        int i=populationService.addPopulation(population);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updatePopulation")
    public Result updatePopulation(@RequestBody Population population) {
       int i=populationService.updatePopulation(population);
       return ResultStatusUtil.JudgeNum(i);
    }


}
