package com.enn.lesson_test.enums;

import com.enn.lesson_test.Exception.InterfaceException;

/**枚举类主要用于捕获系统异常*/
public enum CommonEnum implements InterfaceException {
    //枚举对象中的参数应该有构造器，没有构造器就爆红
    //因为每个枚举对象其实也可以看做是普通对象，创建时参数一致，需要有有参构造器
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");

    private Integer code;
    private String msg;

    CommonEnum(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    //枚举类只有get方法，为防止修改没有set方法
    @Override
    public Integer getExceptionCode(){
        return code;
    }
    @Override
    public String getExceptionMessage(){
        return msg;
    }


}
