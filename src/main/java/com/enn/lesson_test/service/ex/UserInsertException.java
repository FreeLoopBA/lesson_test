package com.enn.lesson_test.service.ex;

public class UserInsertException extends ServiceException{
    public UserInsertException() {
    }

    public UserInsertException(String message) {
        super(message);
    }

    public UserInsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInsertException(Throwable cause) {
        super(cause);
    }

    public UserInsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
