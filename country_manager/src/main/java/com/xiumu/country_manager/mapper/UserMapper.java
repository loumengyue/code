package com.xiumu.country_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiumu.country_manager.pojo.Population;
import com.xiumu.country_manager.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> getAllUser(User user);
    User getUserById(int id);
    User getUserByName(String userName);

    int addUser(User user);
    int deleteUser(int id);
    int updateUser(User user);


    @Select("select * from user_manage where user_phone =#{userPhone}")
    User getUserByPhone(String userPhone);

    /*Select * from user_manage where user_name='admin001' and password='123456';*/
    @Select("Select * from user_manage where user_name=#{userName} and password=#{password}")
    User getUserByLogin(String userName,String password);//新加的lmy，改后

    /*@Select("Select * from user_manage")*/
    List<User> getUserList();//新加的lmy，改后






}
