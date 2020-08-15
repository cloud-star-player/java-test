package com.example.adminteacher.service.impl;

import com.example.adminteacher.mapper.TeacherMapper;
import com.example.adminteacher.mapper.UserMapper;

import com.example.adminteacher.service.TeacherService;
import com.example.adminteacher.service.UserService;
import com.example.common.pojo.Teacher;
import com.example.common.pojo.Student;
import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceimpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageResult<Teacher> sellect(Integer page) {
        PageHelper.startPage(page, 5);
        List<Teacher> list = teacherMapper.sellect();
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<Teacher> result = new PageResult<Teacher>();
        result.setData(list);    //每页的数据
        result.setCount(pageInfo.getTotal());    //总共有多少记录数
        result.setPages(pageInfo.getPages());       //总共页数
        result.setSfFirstPage(pageInfo.isIsFirstPage());//是否为第一页
        result.setSfLastPage(pageInfo.isIsLastPage());//是否为最后一页
        result.setHasNextPage(pageInfo.isHasNextPage());//是否有下一页
        result.setHasPreviousPage(pageInfo.isHasPreviousPage());//是否有上一页
        result.setFirstPage(pageInfo.getFirstPage()); //首页页码
        result.setLastPage(pageInfo.getLastPage());//尾页页码
        result.setNavigatepageNums(pageInfo.getNavigatepageNums());//所有导航页号
        result.setPageSize(pageInfo.getPageSize());//当前页面显示的数据条目
        result.setPageNum(page);           //当前页数(从1开始)
        return result;
    }

    @Override
    public ResponseResult register(Teacher teacher) {
        try {
            int i= teacherMapper.register(teacher);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult teaupdate(Teacher teacher) {
        try {
            int i= teacherMapper.teaupdate(teacher);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult teadel(String tno) {
        try {
            int i= teacherMapper.teadel(tno);
        }catch (Exception e){
            return ResponseResult.build(500,"删除失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public Teacher teaselectid(String tno) {
        return teacherMapper.teaselectid(tno);
    }

    @Override
    public ResponseResult teadels(List snoList) {
        try {
            int i= teacherMapper.teadels(snoList);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }
}
