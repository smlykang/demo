package com.example.demo.design.enums;

public enum RoleEnum implements RoleOperation {
    // 系统管理员
    ROOT_ADMIN {
        @Override
        public String operation() {
            return "ADMIN";
        }
    },
    // 订单管理员
    ROOT_ORDER {
        @Override
        public String operation() {
            return "ORDER";
        }
    },
    // 普通用户
    ROOT_USER {
        @Override
        public String operation() {
            return "USER";
        }
    }


}
