package com.bsus.mapper;

import com.bsus.vo.BaseUser;
import com.bsus.vo.Score;
import com.bsus.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    public User loginByUsername(String username);

    public boolean addUser(@Param("username") String username, @Param("password")  String password);

    List<BaseUser> selectUsers();

    BaseUser queryUserById(@Param("id") Integer id);

    int selectUserByName(@Param("username") String username);

    int  updateUser(User user);

    // 新增用户
    public int addUserVo(User user);

    //根据id删除用户
    public int deleteUserById(Integer id);

}
