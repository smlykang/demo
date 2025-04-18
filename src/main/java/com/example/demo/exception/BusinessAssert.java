package com.example.demo.exception;

import java.util.Collection;

public class BusinessAssert {

    // 基础断言方法
    public static void isTrue(boolean condition, ErrorCode errorCode) {
        if (!condition) {
            throw new BusinessException(errorCode);
        }
    }

    // 带自定义消息的断言
    public static void isTrue(boolean condition, ErrorCode errorCode, String customMessage) {
        if (!condition) {
            throw new BusinessException(errorCode, customMessage);
        }
    }

    // 对象非空断言
    public static void notNull(Object obj, ErrorCode errorCode) {
        if (obj == null) {
            throw new BusinessException(errorCode);
        }
    }

    // 集合非空断言
    public static void notEmpty(Collection<?> collection, ErrorCode errorCode) {
        if (collection == null || collection.isEmpty()) {
            throw new BusinessException(errorCode);
        }
    }
}
