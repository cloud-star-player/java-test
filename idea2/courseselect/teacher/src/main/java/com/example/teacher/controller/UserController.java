package com.example.teacher.controller;

import com.example.teacher.pojo.User;
import com.example.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public User login(User teacher){
        return userService.login(teacher.getTno(),teacher.getPassword(),teacher.getType());
    }
}
