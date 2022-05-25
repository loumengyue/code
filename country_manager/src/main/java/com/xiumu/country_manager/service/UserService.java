package com.xiumu.country_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.User;

import java.util.List;


public interface UserService extends IService<User> {
    /**
     * 查询所有
     * @return
     */
    PageInfo getAllUser(User user,int start, int pageSize);

    /**
     * 根据id获取指定
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 添加
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 修改
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 登录
     * @param userName
     */
    User getUserByName(String userName);

    /**
     * 根据手机号获取用户
     * @return
     */
    User getUserByPhone(String userPhone);

    User getUserByLogin(String userName,String password);//新加的lmy，改后

    List<User> getUserList();//新加的lmy，改后
}
