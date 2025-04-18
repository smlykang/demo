package com.example.demo.design.context;


import com.example.demo.design.enums.RoleOperation;

public class RoleContext {

    // 不同的策略对象，进行不同的业务处理
    private final RoleOperation roleOperation;

    public RoleContext(RoleOperation roleOperation) {
        this.roleOperation = roleOperation;
    }

    public String execute() {
        return roleOperation.operation();
    }
}
