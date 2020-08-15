package com.example.students.service.impl;


import com.example.common.pojo.Student;
import com.example.students.mapper.UserMapper;
import com.example.students.pojo.User;
import com.example.students.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Student login(String sno, String password) {
        return userMapper.login(sno, password);
    }
}
