package com.example.demo.design.factory;


import com.example.demo.design.enums.RoleEnum;
import com.example.demo.design.enums.RoleOperation;

import java.util.HashMap;
import java.util.Map;

public class RoleFactory {

    static Map<String, RoleOperation> roleOperationMap = new HashMap<>();
    // 静态模块中初始化
    static {
        roleOperationMap.put(RoleEnum.ROOT_ADMIN.name(), new RootAdmin(RoleEnum.ROOT_ADMIN.name()));
        roleOperationMap.put(RoleEnum.ROOT_ORDER.name(), new RootOrder(RoleEnum.ROOT_ORDER.name()));
        roleOperationMap.put(RoleEnum.ROOT_USER.name(), new RootUser(RoleEnum.ROOT_USER.name()));
    }

    public static RoleOperation getRoleOperation(String roleName) {
        return roleOperationMap.get(roleName);
    }
}
