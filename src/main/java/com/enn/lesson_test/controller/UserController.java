package com.enn.lesson_test.controller;

import com.enn.lesson_test.annotation.PrintLog;
import com.enn.lesson_test.entity.User;
import com.enn.lesson_test.service.impl.UserServiceImpl;
import com.enn.lesson_test.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController extends BaseController{
    @Autowired
    private UserServiceImpl userService;

    @PrintLog(value = "添加/注册新用户" )
    //这个例子用抛出异常来测试一下
    @RequestMapping("/adds")
    public Map addUser(@RequestBody User user){
        Map map=userService.addUser(user);
        //return new JsonResult<>(Ok,"添加用户数据成功");
        return map;
    }

    @RequestMapping("/adds2")
    public JsonResult<Void> addUser2(@RequestBody User user){
        //log.info("插入一个空指针异常，进行测试——————————***————————————");
        //String str=null;
        //str.equals("111");
        userService.addUser2(user);
        return new JsonResult<>(Ok,"添加用户数据成功");
    }

    @PrintLog(value = "查询用户详细信息" )
    //@RequestMapping("/finds/{uid}")
    //public JsonResult<User> findUser(@PathVariable Integer uid){
    @RequestMapping("/finds")
    public JsonResult<User> findUser(@RequestParam Integer uid){
        System.out.println(uid);
        User result=userService.findUser(uid);
        return new JsonResult<User>(Ok,"查询用户信息成功",result);
    }

    /**密码修改需要传入用户名、旧密码、新密码*/
    @PrintLog(value = "修改用户密码" )
    @RequestMapping("/updates")
    public JsonResult<Void> updateUserPassword(@RequestParam String oldpassword,@RequestParam String newpassword,HttpSession session){
        System.out.println("Session中的uid=" + getUidSession(session));
        System.out.println("Session中的username=" + getUsernameSession(session));
        Integer uid=getUidSession(session);
        userService.updateUserPassword(uid,oldpassword,newpassword);
        return new JsonResult<Void>(Ok,"密码修改成功");
    }

    @PrintLog(value = "删除用户相关信息" )
    @RequestMapping("/deletes")
    public JsonResult<Void> deleteUserMessage(HttpSession session){
        Integer uid=getUidSession(session);
        userService.deleteUserMessage(uid);
        return new JsonResult<Void>(Ok,"注销用户成功");
    }

    @PrintLog(value = "用户登录信息" )
    @RequestMapping("/logins")
    public JsonResult<Map> login(String username,String password,HttpSession session){
        User result=userService.login(username,password);
        session.setAttribute("uid",result.getUid());
        session.setAttribute("username",result.getUsername());
        System.out.println("Session中的uid=" + getUidSession(session));
        System.out.println("Session中的username=" + getUsernameSession(session));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username",result.getUsername());
        map.put("gender",result.getGender());
        return new JsonResult<Map>(Ok,"登录成功",map);
    }
    @RequestMapping("/test2/{id}")
    public Integer test1(@PathVariable Integer id){
        return id;
    }

}
