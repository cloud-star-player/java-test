package com.example.adminteacher.service;



import com.example.common.pojo.Student;
import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherService {
    PageResult<Teacher> sellect(Integer page);
    ResponseResult register(Teacher teacher);
    ResponseResult teaupdate(Teacher teacher);
    ResponseResult teadel(String tno);
    Teacher teaselectid(String tno);
    ResponseResult teadels(@Param("snoList") List snoList);
}
