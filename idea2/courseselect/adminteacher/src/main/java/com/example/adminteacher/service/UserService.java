package com.example.adminteacher.service;


import com.example.common.pojo.Teacher;

public interface UserService {
    Teacher login(String sno, String password, Integer type);
}
