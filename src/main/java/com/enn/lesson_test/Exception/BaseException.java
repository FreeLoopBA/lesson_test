package com.enn.lesson_test.Exception;

import com.enn.lesson_test.enums.CommonEnum;
import com.enn.lesson_test.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BaseException {
    JsonResult<Void> json=new JsonResult<>();
    @ExceptionHandler(value =BizException.class)
    public JsonResult<Void> getJsonException(BizException e){
        System.out.println("错误拦截成功~~~~~~");
        //JsonResult<Void> json=new JsonResult<>();
        log.info("状态码为{}，描述为{}",e.getCode(),e.getMes());
        json.setState(e.getCode());
        json.setMessage(e.getMes());
        //log.info("json的结果为=",json);
        return json;
    }
    @ExceptionHandler(value =NullPointerException.class)
    public JsonResult<Void> getNullException(NullPointerException e){
        log.info("状态码为{}，描述为{}", CommonEnum.BODY_NOT_MATCH.getExceptionCode(),CommonEnum.BODY_NOT_MATCH.getExceptionMessage());
        json.setState(CommonEnum.BODY_NOT_MATCH.getExceptionCode());
        json.setMessage(CommonEnum.BODY_NOT_MATCH.getExceptionMessage());
        return json;
    }
    @ExceptionHandler(value =Exception.class)
    public JsonResult<Void> getNullException(Exception e){
        log.info("状态码为{}，描述为{}", CommonEnum.INTERNAL_SERVER_ERROR.getExceptionCode(),CommonEnum.INTERNAL_SERVER_ERROR.getExceptionMessage());
        json.setState(CommonEnum.INTERNAL_SERVER_ERROR.getExceptionCode());
        json.setMessage(CommonEnum.INTERNAL_SERVER_ERROR.getExceptionMessage());
        return json;
    }
}
