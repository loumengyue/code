package com.xiumu.country_manager.controller;


import cn.hutool.json.JSON;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.PageArgsPro;
import com.xiumu.country_manager.pojo.User;
import com.xiumu.country_manager.service.UserService;
import com.xiumu.country_manager.utils.Code;
import com.xiumu.country_manager.utils.Result;
import com.xiumu.country_manager.utils.ResultStatusUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 村委人事功能
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String secret;

    @PostMapping("/getAllUser")
    public Result getAllUser(@RequestBody PageArgsPro<User> userPageArgsPro) {
        User user = userPageArgsPro.getCondition();
        int pageNum = userPageArgsPro.getPageNum();
        int pageSize = userPageArgsPro.getPageSize();
        userPageArgsPro.getCondition();
        PageInfo allUser = userService.getAllUser(user,pageNum, pageSize);
        return ResultStatusUtil.JudgeStatus(allUser);

    }

    @PostMapping("/getUserList")
    public Result getUserList(){
        List<User> all =userService.getUserList();
        return ResultStatusUtil.JudgeStatus(all);
    }//新加的lmy，改后

    @GetMapping("/getUserById")
    public Result getUserById(Integer id) {
        User userById = userService.getUserById(id);
        return ResultStatusUtil.JudgeStatus(userById);
    }
    @PostMapping("/getUserByName")
    public Result getUserByName(@RequestBody User user){
        String username=user.getUserName();
        User userByName=userService.getUserByName(username);
        return ResultStatusUtil.JudgeStatus(userByName);
    }

    @GetMapping("/deleteUser")
    public Result deleteUser(Integer id) {
        int i = userService.deleteUser(id);
        System.out.println(i);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        User temp = userService.getUserByPhone(user.getUserPhone());
        if (temp != null){
            return new Result(Code.FAIL,"添加失败，该手机号已存在！！");
        }
        int i = userService.addUser(user);
        return ResultStatusUtil.JudgeNum(i);
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        int i = userService.updateUser(user);
        return ResultStatusUtil.JudgeNum(i);
    }

    /**
     * 登录
     */

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println("前端用户名："+user);//用户名：User(userId=0, userName=admin, password=123456, gender=null, userPhone=null, nickName=null, userRoleId=0
        User userByLogin = userService.getUserByLogin(user.getUserName(),user.getPassword());

        Map<String, Object> res = new HashMap<String, Object>();
        String flag;
        if(userByLogin!=null){                                                   //登录成功
            System.out.println("数据库用户名："+userByLogin);
            flag="LoginOK";
            res.put("flag",flag);                                                    //flag=ok  登录成功   flag=error  登录失败
            res.put("userName",userByLogin.getUserName());                           //哈希表存放flag和用户名
            res.put("role",userByLogin.getUserRoleId());                       //哈希表存放flag和用户名和用户角色
            res.put("nickName",userByLogin.getNickName());                       //哈希表存放flag和用户名和用户角色
            res.put("userVillageId",userByLogin.getUserVillageId());
        }else{
            flag="LoginError";
            res.put("flag",flag);                                                    //flag=LoginOK  登录成功   flag=LoginError  登录失败
        }
        return ResultStatusUtil.JudgeStatus(res);                                //

    }//新加的login-002-lmy

}
