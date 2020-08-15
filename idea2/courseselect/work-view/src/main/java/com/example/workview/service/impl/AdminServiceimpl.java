package com.example.workview.service.impl;

import com.example.common.pojo.Student;
import com.example.common.pojo.Teacher;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.AdminService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/3 17:32
 */
@Component
public class AdminServiceimpl implements AdminService {


    @Override
    public ResponseResult login(Teacher teacher) {
        return ResponseResult.build(401,"系统异常");
    }
}