package com.example.workview.service.impl;

import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.TeacherService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/6/11 19:39
 */
@Component
public class TeacherServiceimpl implements TeacherService {
    @Override
    public PageResult elCeall(Integer page) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public ResponseResult elCedel(String tno) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCeupdate(Teacher teacher) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCeadd(Teacher teacher) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCid(String tno) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }
}
