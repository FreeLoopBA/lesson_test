package com.enn.lesson_test.service.ex;

public class UpdatePasswordException extends ServiceException{
    public UpdatePasswordException() {
    }

    public UpdatePasswordException(String message) {
        super(message);
    }

    public UpdatePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdatePasswordException(Throwable cause) {
        super(cause);
    }

    public UpdatePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
