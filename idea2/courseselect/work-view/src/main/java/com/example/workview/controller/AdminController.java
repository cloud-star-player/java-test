package com.example.workview.controller;

import com.example.common.pojo.Student;
import com.example.common.pojo.Teacher;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/3 14:25
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult login(@RequestBody Teacher teacher){
        System.out.println(teacher);
        return adminService.login(teacher);
    }


}
