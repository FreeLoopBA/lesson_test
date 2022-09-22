package com.enn.lesson_test.interceptor;

import com.enn.lesson_test.controller.BaseController;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**拦截器设置*/
@Slf4j
@Configuration
public class LoginInterception  implements HandlerInterceptor {
    //定义只要登陆了就放行，否则拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl=request.getRequestURI();
        log.info("进入拦截器————{}————————***********————————————————",requestUrl);
        HttpSession session=request.getSession();
        Object uid=session.getAttribute("uid");
        Object username=session.getAttribute("username");
        if(uid==null){
            response.sendRedirect("/web/login.html");
            log.info("应该拦截就对了！！！");
            return false;
        }
        return true;
    }

}
