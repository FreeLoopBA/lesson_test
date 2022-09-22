package com.enn.lesson_test.config;

import com.enn.lesson_test.interceptor.LoginInterception;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**进行拦截器配置,注意添加Component注解，才能扫描到拦截器*/
@Component
public class AdminWebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //将创建的拦截器加入配置
        // 白名单
        registry.addInterceptor(new LoginInterception())
                //配置拦截路径
                .addPathPatterns("/**")
                //放行路径
                .excludePathPatterns("/","/error","/logins","/finds","/adds",
                        "/web/common.html", "/web/login.html", "/web/**","/templates/**","/atguigu","/success","/upload","/success.html");

    }

}
