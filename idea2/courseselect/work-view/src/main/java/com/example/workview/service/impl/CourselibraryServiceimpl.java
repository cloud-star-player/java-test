package com.example.workview.service.impl;

import com.example.common.pojo.CourseLibrary;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.CourselibraryService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/6/11 19:47
 */
@Component
public class CourselibraryServiceimpl implements CourselibraryService {
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
    public ResponseResult elCeupdate(CourseLibrary courseLibrary) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCeadd(CourseLibrary courseLibrary) {
        return ResponseResult.build(401,"系统异常");
    }

    @Override
    public ResponseResult elCid(Integer elective_course_id) {
        return ResponseResult.build(401,"系统异常");
    }
}
