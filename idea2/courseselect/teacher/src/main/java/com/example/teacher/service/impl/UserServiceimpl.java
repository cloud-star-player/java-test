package com.example.teacher.service.impl;

import com.example.teacher.mapper.UserMapper;
import com.example.teacher.pojo.User;
import com.example.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String sno, String password,Integer type) {
        return userMapper.login(sno,password,type);
    }
}
