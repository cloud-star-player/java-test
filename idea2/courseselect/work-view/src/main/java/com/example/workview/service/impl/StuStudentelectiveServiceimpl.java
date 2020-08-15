package com.example.workview.service.impl;

import com.example.common.pojo.StudentElective;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.StuStudentelectiveService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/6/11 19:37
 */
@Component
public class StuStudentelectiveServiceimpl implements StuStudentelectiveService {

    @Override
    public PageResult elCeall(Integer page) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public ResponseResult elCedel(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCeupdate(StudentElective studentelective) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCeadd(StudentElective studentelective) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCid(Integer student_elective_id) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public PageResult perforall(Integer page) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public ResponseResult elective_course_id(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }
}
