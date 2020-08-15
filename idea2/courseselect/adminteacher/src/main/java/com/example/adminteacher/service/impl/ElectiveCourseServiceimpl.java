package com.example.adminteacher.service.impl;

import com.example.adminteacher.mapper.ElectiveCourseMapper;
import com.example.adminteacher.service.ElectiveCourseService;
import com.example.common.pojo.ElectiveCourse;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/30 21:32
 */
@Service
@Transactional
public class ElectiveCourseServiceimpl implements ElectiveCourseService{
    @Autowired
    private ElectiveCourseMapper electiveCourseMapper;

    @Override
    public PageResult<ElectiveCourse> elCeall(Integer page) {
        PageHelper.startPage(page, 5);
        List<ElectiveCourse> list = electiveCourseMapper.elCeall();
        PageInfo<ElectiveCourse> pageInfo = new PageInfo<ElectiveCourse>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<ElectiveCourse> result = new PageResult<ElectiveCourse>();
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
    public ResponseResult elCedel(Integer elective_course_id) {
        try {
            int i=electiveCourseMapper.elCedel(elective_course_id);
        }catch (Exception e){
            return ResponseResult.build(500,"删除失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeadd(ElectiveCourse electivecourse) {
        try {
            int i=electiveCourseMapper.elCeadd(electivecourse);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeupdate(ElectiveCourse electivecourse) {
        try {
            int i=electiveCourseMapper.elCeupdate(electivecourse);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        try {
            int i=electiveCourseMapper.elCedels(snoList);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ElectiveCourse elCid(Integer elective_course_id) {
        return electiveCourseMapper.elCid(elective_course_id);
    }

    @Override
    public ResponseResult elCupselect(Integer elective_course_id) {
        try {
            int i=electiveCourseMapper.elCupselect(elective_course_id);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCnoselect(Integer elective_course_id) {
        try {
            int i=electiveCourseMapper.elCnoselect(elective_course_id);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }


}
