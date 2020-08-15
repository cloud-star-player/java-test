package com.example.students.service;


import com.example.common.pojo.Performance;
import com.example.common.pojo.StudentElective;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface StuStudentelectiveService {
    PageResult<StudentElective> elCeall(Integer page);
    ResponseResult elCedel(Integer student_elective_id);
    ResponseResult elCeadd(StudentElective electivecourse);
    ResponseResult elCedels(@Param("snoList") List snoList);
    StudentElective elCid(Integer student_elective_id);
    PageResult<Performance>perforall(Integer page);
    StudentElective elCselecttive(Integer elective_course_id);
}
