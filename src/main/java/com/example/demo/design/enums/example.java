package com.example.demo.design.enums;

public class example {

    public String getRole(String roleName) {
        String result = "UNKNOWN";
        switch (roleName) {
            // 系统管理员
            case "ROOT_ADMIN":
                result = "ADMIN";
                break;
            // 订单管理员
            case "ROOT_ORDER":
                result = "ORDER";
                break;
            // 普通用户
            case "ROOT_USER":
                result = "USER";
                break;
        }
        return result;
    }
}
