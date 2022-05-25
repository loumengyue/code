package com.xiumu.country_manager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiumu.country_manager.mapper.PopulationMapper;
import com.xiumu.country_manager.mapper.UserMapper;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.User;
import com.xiumu.country_manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo getAllUser(User user,int start, int pageSize) {
        PageHelper.startPage(start,pageSize);
        List<User> allUser = userMapper.getAllUser(user);
        PageInfo<User> pageInfo=new PageInfo(allUser);
        return pageInfo;
    }

    @Override
    public List<User> getUserList(){
        return userMapper.getUserList();
    }//新加的lmy，改后

    @Override
    public User getUserById(int id) {
        User userById = userMapper.getUserById(id);
        return userById;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUserByName(String userName) {
        User user = userMapper.getUserByName(userName);
        if(user!=null){
            return user;
        }
        return null;
    }

    @Override
    public User getUserByPhone(String userPhone) {
        return userMapper.getUserByPhone(userPhone);
    }

    @Override
    public User getUserByLogin(String userName,String password){
        return userMapper.getUserByLogin(userName,password);
    }//新加的lmy，改后
}
