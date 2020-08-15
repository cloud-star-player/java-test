package com.example.students.service.impl;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.pojo.Performance;
import com.example.common.pojo.StudentElective;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.students.mapper.StuStudentelectiveMapper;
import com.example.students.service.StuStudentelectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/5 17:25
 */
@Service
@Transactional
public class StuStudentelectiveServiceimpl implements StuStudentelectiveService {
    @Autowired
    private StuStudentelectiveMapper stuStudentelectiveMapper;

    @Override
    public PageResult<StudentElective> elCeall(Integer page) {
        PageHelper.startPage(page, 5);
        List<StudentElective> list = stuStudentelectiveMapper.elCeall();
        PageInfo<StudentElective> pageInfo = new PageInfo<StudentElective>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<StudentElective> result = new PageResult<StudentElective>();
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
    public ResponseResult elCedel(Integer student_elective_id) {
        try {
            int i=stuStudentelectiveMapper.elCedel(student_elective_id);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeadd(StudentElective studentelective) {
        try {
            int i=stuStudentelectiveMapper.elCeadd(studentelective);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        try {
            int i=stuStudentelectiveMapper.elCedels(snoList);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public StudentElective elCid(Integer student_elective_id) {
        return stuStudentelectiveMapper.elCid(student_elective_id);
    }

    @Override
    public PageResult<Performance> perforall(Integer page) {
        PageHelper.startPage(page, 5);
        List<Performance> list = stuStudentelectiveMapper.perforall();
        PageInfo<Performance> pageInfo = new PageInfo<Performance>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<Performance> result = new PageResult<Performance>();
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
    public StudentElective elCselecttive(Integer elective_course_id) {
        return stuStudentelectiveMapper.elCselecttive(elective_course_id);
    }
}
