package com.example.demo.specification;

import com.example.demo.entity.User;

public class NamingConvention {

    /**
     * 命名规范
     * <p>
     * 类/接口：使用名词或名词短语，体现职责（如UserController、UserService）。
     * 方法：使用动词或动宾结构，明确行为（如selectUser()、createUser()、updateUser()、getUser()、deleteUser()）。
     * 变量：避免缩写，体现用途（如 userAddress 而非 addr）,以驼峰格式命名。
     * 常量：全大写 + 下划线，明确含义（如 MAX_RETRY_COUNT = 3）
     */

    public void convention() {
        // 反例
        User u = new User();
        String n = u.getName();

        // 正例
        User user = new User();
        String userName = u.getName();
    }
}
