package com.enn.lesson_test.Exception;

import com.enn.lesson_test.util.JsonResult;

import java.util.Objects;

/**自定义的一个异常类*/
public class BizException extends RuntimeException{
    private Integer code;
    private String mes;

    public BizException(Integer code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public BizException(String message, Integer code, String mes) {
        super(message);
        this.code = code;
        this.mes = mes;
    }

    public BizException(String message, Throwable cause, Integer code, String mes) {
        super(message, cause);
        this.code = code;
        this.mes = mes;
    }

    public BizException(Throwable cause, Integer code, String mes) {
        super(cause);
        this.code = code;
        this.mes = mes;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BizException that = (BizException) o;
        return Objects.equals(code, that.code) && Objects.equals(mes, that.mes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, mes);
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code +
                ", mes='" + mes + '\'' +
                '}';
    }
}
