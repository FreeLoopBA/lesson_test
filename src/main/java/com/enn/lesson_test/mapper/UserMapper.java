package com.enn.lesson_test.mapper;

import com.enn.lesson_test.entity.User;
import org.apache.ibatis.annotations.Param;

/**Dao层接口编写*/
public interface UserMapper {
    /**添加用户*/
    Integer addUser(User user);
    /**通过id查询用户*/
    User findUser(Integer uid);
    /**更新用户密码*/
    Integer updateUserPassword(@Param("uid") Integer uid, @Param("password") String password,@Param("salt") String salt);
    /**通过名字查询用户*/
    User findByName(String username);
    /**删除操作*/
    Integer deleteUserMessage(Integer uid);

}
