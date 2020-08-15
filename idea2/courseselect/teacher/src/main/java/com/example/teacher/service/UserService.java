package com.example.teacher.service;

import com.example.teacher.pojo.User;

public interface UserService {
    User login(String sno, String password,Integer type);
}
