package com.enn.lesson_test.service;

import com.enn.lesson_test.entity.User;

import java.util.Map;

public interface IUserService {
    /**添加用户*/
    Map addUser(User user);
    void addUser2(User user);
    /**查询用户*/
    User findUser(Integer uid);
    User findByName(String username);
    /**更新用户密码*/
    void updateUserPassword(Integer uid,String oldpassword,String password);
    /**删除用户信息*/
    void deleteUserMessage(Integer uid);
    /**为让修改密码拥有用户权限，设置一个登录操作*/
    User login(String username,String password);
}
