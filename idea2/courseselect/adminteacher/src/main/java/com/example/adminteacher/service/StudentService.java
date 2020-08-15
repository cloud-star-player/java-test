package com.example.adminteacher.service;

import com.example.common.pojo.Student;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface StudentService {
    List<Student> stuselect();
    PageResult<Student> stuselects(Integer page);
    ResponseResult stuupdate(Student student);
    int studel(String sno);
    Student stuselectid(String sno);
    int studels(List snoList);
    ResponseResult stuadd(Student student);
}
