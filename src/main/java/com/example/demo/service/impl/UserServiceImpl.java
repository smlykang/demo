package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BusinessAssert;
import com.example.demo.exception.ErrorCode;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(Long id) {
        User user = new User();
        BusinessAssert.notNull(user, ErrorCode.USER_NOT_FOUND);
        return user;
    }
}
