package com.example.workview.service.impl;

import com.example.common.pojo.Student;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.AdminStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/3 19:57
 */
@Component
public class AdminStudentServiceimpl implements AdminStudentService{
    @Autowired
     private AdminStudentService adminStudentService;
    @Override
    public PageResult itemList(Integer pageNum) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public ResponseResult stuadd(Student student) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult stuupdate(Student student) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public int studel(String sno) {
        return 0;
    }

    @Override
    public Student stuselectid(String sno) {
        return  adminStudentService.stuselectid(sno);
    }

    @Override
    public int studels(List snoList) {
        return 0;
    }

    @Override
    public ResponseResult stulogin(Student student) {
        return ResponseResult.build(401,"系统异常");
    }
}
