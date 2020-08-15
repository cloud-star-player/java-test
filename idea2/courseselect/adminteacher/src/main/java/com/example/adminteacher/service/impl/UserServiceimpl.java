package com.example.adminteacher.service.impl;

import com.example.adminteacher.mapper.UserMapper;

import com.example.adminteacher.service.UserService;
import com.example.common.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Teacher login(String sno, String password, Integer type) {
        return userMapper.login(sno,password,type);
    }
}
