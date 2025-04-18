package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 标准错误响应类
 */

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
    private String details; // 可选，用于调试信息
}
