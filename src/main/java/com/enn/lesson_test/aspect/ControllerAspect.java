package com.enn.lesson_test.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.enn.lesson_test.annotation.PrintLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Date;

@Slf4j
@Component
@Aspect
public class ControllerAspect {
    /**采用两种方式试试
     *  方法一： 不需要自定义注解， 直接拦截所有controller的请求。全部打印
     *  方法二：拦截该注解标识的方法 */
    @Pointcut("execution(public * com.enn.lesson_test.controller..*.*(..))")
    public void privilege(){}
    @Pointcut("@annotation(com.enn.lesson_test.annotation.PrintLog)")
    public void logPointCut(){}

    //@Around("privilege()") // 第一种方式
    @Around("logPointCut()") // 第二种方式
    public Object arount(ProceedingJoinPoint pjd) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 类名
        String className = pjd.getTarget().getClass().getName();
        // 获取执行的方法名称
        String methodName = pjd.getSignature().getName();

        // 1. 如果是使用的第二种方式，则判断该方法是否使用了改注解
        // 2. 如果是使用的第一种方式，直接注释即可。

        PrintLog gmLog = this.getAnnotationLog(pjd);
        if (gmLog != null) {
            String value = gmLog.value();
            log.info("{}.{}()【{}】：===================", className, methodName, value);
        }

        Object[] args = pjd.getArgs();
        try {
            String params = JSON.toJSONString(args[0]);
            //打印请求参数参数
            log.info("{}.{}()【方法请求参数为】：{}", className, methodName, params);
        } catch (Exception e) {
            log.info("{}.{}()【方法请求参数打印失败】：{}", className, methodName, e);
        }
        // 执行目标方法
        Object result = pjd.proceed();
        // 打印返回结果
        try {
            String s = JSON.toJSONString(result);
            log.info("{}.{}()【方法返回结果为】：{}", className, methodName, s);
        } catch (Exception e) {
            log.info("{}.{}()【方法返回结果打印失败】：{}", className, methodName, e);
        }
        // 获取执行完的时间
        long time = System.currentTimeMillis() - startTime;
        log.info("{}.{}()【方法执行时长为】：{}{}", className, methodName, time, " ms");
        // 如果使用第一种方式，把这里注释掉
        return result;
    }

    /**
     * 是否存在注解，如果存在就获取
     * @param joinPoint
     * @return
     */
    private PrintLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(PrintLog.class);
        }
        return null;
    }


}
