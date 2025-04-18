package com.example.demo.exception;

import lombok.Getter;

/**
 * 基础业务异常类
 */
@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    // 基础构造
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    // 支持自定义消息覆盖
    public BusinessException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
    }

    // 带原始异常的构造
    public BusinessException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

    // 完整构造
    public BusinessException(ErrorCode errorCode, String customMessage, Throwable cause) {
        super(customMessage, cause);
        this.errorCode = errorCode;
    }

}
