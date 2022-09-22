package com.enn.lesson_test.service.ex;

public class Biz2Exception extends ServiceException{
    public Biz2Exception() {
    }

    public Biz2Exception(String message) {
        super(message);
    }

    public Biz2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Biz2Exception(Throwable cause) {
        super(cause);
    }
}
