package com.example.adminteacher.service.impl;

import com.example.adminteacher.mapper.StudentMapper;
import com.example.adminteacher.service.StudentService;
import com.example.common.pojo.Student;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/1 21:07
 */
@Service
@Transactional
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> stuselect() {
        return studentMapper.stuselect();
    }

    @Override
//    @Cacheable(value ="PageResult",key="'result'")

    public PageResult<Student> stuselects(Integer page) {
        PageHelper.startPage(page, 5);
        List<Student> list = studentMapper.stuselects();
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<Student> result = new PageResult<Student>();
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
//    @CacheEvict(value ="PageResult",key="'result'")
    public ResponseResult stuupdate(Student student) {
        try {
            int i=studentMapper.stuupdate(student);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }


    @Override
//    @CacheEvict(value ="PageResult",key="'result'")
    public int studel(String sno) {
        return studentMapper.studel(sno);
    }

    @Override
    public Student stuselectid(String sno) {
        return studentMapper.stuselectid(sno);
    }


    @Override
//    @CacheEvict(value ="PageResult",key="'result'")
    public int studels(List snoList) {
        return studentMapper.studels(snoList);
    }

    @Override
//    @CacheEvict(value ="PageResult",key="'result'")
    public ResponseResult stuadd(Student student) {
        try {
        int i= studentMapper.stuadd(student);
        }catch (Exception e){
            return ResponseResult.build(500,"添加失败");
        }
        return ResponseResult.ok();
    }


}
