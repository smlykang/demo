package com.example.demo.exception;

/**
 * 参数校验异常类
 */
public class ValidationException extends BusinessException {

    public ValidationException(String errorCode, String message) {
        super(errorCode, message);
    }

}
