package com.xiumu.country_manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Helper;
import com.xiumu.country_manager.pojo.House;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.service.HouseService;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 宅基地管理
 */
@RestController
@CrossOrigin
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping("/getAllHouse")
    public Result getAllHouse(@RequestBody PageArgsPro<House> housePageArgsPro) {
        House house = housePageArgsPro.getCondition();
        int pageNum = housePageArgsPro.getPageNum();
        int pageSize = housePageArgsPro.getPageSize();
        PageInfo allHouse = houseService.getAllHouse(house,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allHouse);
    }

    @PostMapping("/getMyAllHouse")
    public Result getMyAllHouse(@RequestBody PageArgsPro<House> housePageArgsPro) {
        House house=housePageArgsPro.getCondition();
        int id=house.getHouseVillageId();
        int pageNum = housePageArgsPro.getPageNum();
        int pageSize = housePageArgsPro.getPageSize();
        PageInfo allHouse=houseService.getMyAllHouse(house,pageNum,pageSize,id);
        return ResultStatusUtil.JudgeStatus(allHouse);

    }

    @PostMapping("/getMyHouseList")
    public Result getMyHouseList(Integer id){
        List<House> all =houseService.getMyHouseList(id);
        return ResultStatusUtil.JudgeStatus(all);
    }
    @PostMapping("/getHouseList")
    public Result getHouseList(){
        List<House> all = houseService.getHouseList();
        Map<String, Object> res = new HashMap<String, Object>();
        String flag="getHouseListOK";
        res.put("flag",flag);
        res.put("houseList",all);                           //哈希表存放flag和用户名
        return ResultStatusUtil.JudgeStatus(res);
    }//新加的lmy，改后5/3

    @GetMapping("/getHouseById")
    public Result getHouseById(Integer id) {
        House houseById = houseService.getHouseById(id);
        return ResultStatusUtil.JudgeStatus(houseById);
    }

    @GetMapping("/deleteHouse")
    public Result deleteHouse(Integer id) {
        int i = houseService.deleteHouse(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addHouse")
    public Result addHouse(@RequestBody House house) {
        int i = houseService.addHouse(house);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateHouse")
    public Result updateHouse(@RequestBody House house) {
        int i = houseService.updateHouse(house);
        return ResultStatusUtil.JudgeNum(i);
    }

}
