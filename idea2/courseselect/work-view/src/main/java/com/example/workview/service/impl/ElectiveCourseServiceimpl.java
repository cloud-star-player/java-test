package com.example.workview.service.impl;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.ElectiveCourseService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/1 17:05
 */
@Component
public class ElectiveCourseServiceimpl implements ElectiveCourseService{
    @Override
    public PageResult elCeall(Integer page) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public ResponseResult elCedel(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCeupdate(ElectiveCourse electiveCourse) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCeadd(ElectiveCourse electiveCourse) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCid(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCupselect(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCnoselect(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常");
    }
}
