package com.example.adminteacher.service;

import com.example.common.pojo.CourseLibrary;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourselibraryService {
    PageResult<CourseLibrary> elCeall(Integer page);
    ResponseResult elCedel(Integer course_id);
    ResponseResult elCeadd(CourseLibrary courseLibrary);
    ResponseResult elCeupdate(CourseLibrary courseLibrary);
    ResponseResult elCedels(@Param("snoList") List snoList);
    CourseLibrary elCid(Integer course_id);
}
