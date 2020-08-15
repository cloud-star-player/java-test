package com.example.students.controller;

import com.example.common.pojo.Student;
import com.example.common.unit.ResponseResult;
import com.example.students.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/stulogin",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestBody Student student){
        Student student1= userService.login(student.getSno(),student.getPassword());
        if (student1 == null){
            return  ResponseResult.build(500,"登陆失败");
        }else{
            return  ResponseResult.build(200,"登陆成功",student1);
        }
    }
}

