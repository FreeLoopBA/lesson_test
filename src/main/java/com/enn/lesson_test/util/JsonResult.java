package com.enn.lesson_test.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {
    private Integer state;
    private String message;
    private E date;

    public JsonResult(){}

    public JsonResult(Integer state){
        this.state=state;
    }

    public JsonResult(Integer state,String message){
        this.state=state;
        this.message=message;
    }

    public JsonResult(Integer state,E date){
        this.state=state;
        this.date=date;
    }

    public JsonResult(Integer state,String message,E date){
        this.state=state;
        this.message=message;
        this.date=date;
    }

    public JsonResult(Throwable e){
        this.message=message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getDate() {
        return date;
    }

    public void setDate(E date) {
        this.date = date;
    }
}
