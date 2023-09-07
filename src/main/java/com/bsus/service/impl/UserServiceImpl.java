package com.bsus.service.impl;

import com.bsus.mapper.UserMapper;
import com.bsus.service.UserService;
import com.bsus.vo.BaseUser;
import com.bsus.vo.Score;
import com.bsus.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User loginByUsername(String username) {
        System.out.println(username);
        return userMapper.loginByUsername(username);
    }

    @Override
    public boolean addUser(String username, String password) {
        try {
            userMapper.addUser(username,password);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<BaseUser> selectUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public BaseUser queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public int selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public boolean updateUser(User user) {
//        return userMapper.updateUser(user);
        int i = userMapper.updateUser(user);
        if(i > 0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean addUserVo(User user) {
        return userMapper.addUserVo(user) > 0 ? true : false ;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        int i = userMapper.deleteUserById(id);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }


}
