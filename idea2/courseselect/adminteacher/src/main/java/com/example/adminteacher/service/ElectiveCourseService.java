package com.example.adminteacher.service;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/30 20:31
 */
public interface ElectiveCourseService {
    PageResult<ElectiveCourse> elCeall(Integer page);
    ResponseResult elCedel(Integer elective_course_id);
    ResponseResult elCeadd(ElectiveCourse electivecourse);
    ResponseResult elCeupdate(ElectiveCourse electivecourse);
    ResponseResult elCedels(@Param("snoList") List snoList);
    ElectiveCourse elCid(Integer elective_course_id);
    ResponseResult elCupselect(Integer elective_course_id);
    ResponseResult elCnoselect(Integer elective_course_id);
}
