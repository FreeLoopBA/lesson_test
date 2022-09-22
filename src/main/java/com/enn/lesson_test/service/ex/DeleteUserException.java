package com.enn.lesson_test.service.ex;

public class DeleteUserException extends ServiceException{
    public DeleteUserException() {
    }

    public DeleteUserException(String message) {
        super(message);
    }

    public DeleteUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteUserException(Throwable cause) {
        super(cause);
    }

    public DeleteUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
