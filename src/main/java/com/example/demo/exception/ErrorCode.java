package com.example.demo.exception;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ErrorCode {
    // 通用错误码
    SUCCESS("0000", "成功"),
    SYSTEM_ERROR("5000", "系统内部错误"),
    INVALID_PARAM("4001", "参数校验失败"),

    // 业务域错误码
    USER_NOT_FOUND("1001", "用户不存在"),
    ORDER_EXPIRED("2001", "订单已过期"),

    // 第三方服务错误码
    PAYMENT_FAILED("3001", "支付服务调用失败");

    // Getters
    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 根据code查找枚举
    public static ErrorCode fromCode(String code) {
        return Arrays.stream(values())
                .filter(e -> e.code.equals(code))
                .findFirst()
                .orElse(SYSTEM_ERROR); // 默认返回系统错误
    }

}
