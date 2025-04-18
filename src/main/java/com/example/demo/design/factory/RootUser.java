package com.example.demo.design.factory;

import com.example.demo.design.enums.RoleEnum;
import com.example.demo.design.enums.RoleOperation;

public class RootUser implements RoleOperation {
    private final String roleName;

    public RootUser(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String operation() {
        // do something
        return RoleEnum.valueOf(roleName).operation();
    }
}
