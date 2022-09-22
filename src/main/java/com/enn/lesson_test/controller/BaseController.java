package com.enn.lesson_test.controller;


import com.enn.lesson_test.Exception.BizException;
import com.enn.lesson_test.service.ex.*;
import com.enn.lesson_test.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
    /**设定统一的顺利通过状态码*/
    public static final Integer Ok=200;

    protected final Integer getUidSession(HttpSession session){
        Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
        return uid;
    }

    protected final String getUsernameSession(HttpSession session){
        String username=session.getAttribute("username").toString();
        return username;
    }


    /**拦截各异常，并为其提供状态码*/
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> json=new JsonResult<>();
        if(e instanceof UsernameDuplicationException){
            json.setState(4000);
            json.setMessage("该用户名已经被占用");
        }else if(e instanceof UserNotFoundException){
            json.setState(4001);
            json.setMessage("查询不到用户信息");
        }else if(e instanceof UserInsertException){
            json.setState(4002);
            json.setMessage("添加操作出现未知错误");
        }else if(e instanceof UpdatePasswordException){
            json.setState(4003);
            json.setMessage("密码更新出现未知错误");
        }else if(e instanceof DeleteUserException){
            json.setState(4004);
            json.setMessage("用户删除出现未知错误");
        }else if(e instanceof PasswordNotMatchException){
            json.setState(4005);
            json.setMessage("用户密码输入不正确");
        }
        return json;
    }

}
