package com.example.adminteacher.service.impl;

import com.example.adminteacher.mapper.CourseLibraryMapper;
import com.example.adminteacher.service.CourselibraryService;
import com.example.common.pojo.CourseLibrary;
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
 * @date ：Created in 2020/5/1 20:53
 */

@Service
@Transactional
public class CourselibraryServiceimpl implements CourselibraryService {
    @Autowired
    private CourseLibraryMapper courselibraryMapper;

    @Override
    public PageResult<CourseLibrary> elCeall(Integer page) {
        PageHelper.startPage(page, 5);
        List<CourseLibrary> list = courselibraryMapper.elCeall();
        PageInfo<CourseLibrary> pageInfo = new PageInfo<CourseLibrary>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<CourseLibrary> result = new PageResult<CourseLibrary>();
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
    public ResponseResult elCedel(Integer course_id) {
        try {
            int i=courselibraryMapper.elCedel(course_id);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeadd(CourseLibrary courseLibrary) {
        try {
            int i=courselibraryMapper.elCeadd(courseLibrary);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeupdate(CourseLibrary courseLibrary) {
        try {
            int i=courselibraryMapper.elCeupdate(courseLibrary);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        try {
            int i=courselibraryMapper.elCedels(snoList);
        }catch (Exception e){
            return ResponseResult.build(500,"失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public CourseLibrary elCid(Integer course_id) {
        return courselibraryMapper.elCid(course_id);
    }
}
