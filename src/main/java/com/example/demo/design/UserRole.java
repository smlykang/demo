package com.example.demo.design;


import com.example.demo.design.context.RoleExecute;
import com.example.demo.design.enums.RoleEnum;
import com.example.demo.design.factory.RoleFactory;
import com.example.demo.design.factory.RootAdmin;

public class UserRole {

    // 枚举
    public String getUserRole(String roleName) {
        return RoleEnum.valueOf(roleName).operation();
    }

    // 工厂模式
    public static String factory(String roleName) {
        return RoleFactory.getRoleOperation(roleName).operation();
    }

    // 策略
    public static String execute(String roleName) {
        RoleExecute roleExecute = new RoleExecute();
        return roleExecute.execute(new RootAdmin(roleName));
    }

    public static void main(String[] args) {
//        String role = factory(RoleEnum.ROOT_ADMIN.name());
//        System.out.println("role:" + role);

        String role = execute(RoleEnum.ROOT_ORDER.name());
        System.out.println("role:" + role);
    }

}
