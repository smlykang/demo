package com.example.demo.exception;

public final class AssertUtils {

    // 通用断言
    public static void isTrue(boolean condition, String errorCode, String message) {
        if (!condition) {
            throw new BusinessException(errorCode, message);
        }
    }

    // 对象非空断言
    public static void notNull(Object obj, String errorCode, String message) {
        if (obj == null) {
            throw new BusinessException(errorCode, message);
        }
    }

    // 字符串非空断言
    public static void notBlank(String str, String errorCode, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new BusinessException(errorCode, message);
        }
    }
}
