package com.bsus.service;


import com.bsus.vo.BaseUser;
import com.bsus.vo.Score;
import com.bsus.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public User loginByUsername(@Param("username") String username);

    public boolean addUser(String username, String password);

    List<BaseUser> selectUsers();

    BaseUser queryUserById(Integer id);

    int selectUserByName(String username);

    boolean updateUser(User user);

    // 新增用户
    public boolean addUserVo(User user);

    //根据id删除用户
    public boolean deleteUserById(Integer id);
}
