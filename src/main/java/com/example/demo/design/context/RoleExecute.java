package com.example.demo.design.context;


import com.example.demo.design.enums.RoleOperation;

public class RoleExecute {

    // 执行
    public String execute(RoleOperation roleOperation) {
        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.execute();
    }
}
