package com.example.workview.service;

import com.example.common.pojo.CourseLibrary;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.CourselibraryServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "adminteacher-client",fallback = CourselibraryServiceimpl.class)
public interface CourselibraryService {
    @RequestMapping(value = "/course/elctalls",method= RequestMethod.POST) 
    public PageResult elCeall(@RequestParam(defaultValue = "1") Integer page);

    @RequestMapping("/course/elcdelete/{elective_course_id}")
    public @ResponseBody
    ResponseResult elCedel(@PathVariable("elective_course_id") Integer elective_course_id);

    @RequestMapping(value="/course/elcdels/{snoList}",method= RequestMethod.POST)
    public ResponseResult elCedels(@RequestParam("snoList") List snoList);

    @RequestMapping(value="/course/update",method= RequestMethod.POST)
    public ResponseResult elCeupdate(@RequestBody CourseLibrary courseLibrary);

    @RequestMapping(value = "/course/add",method= RequestMethod.POST)
    public ResponseResult elCeadd(@RequestBody CourseLibrary courseLibrary);

    @RequestMapping(value = "/course/sid/{elective_course_id}",method= RequestMethod.POST)
    public ResponseResult elCid(@PathVariable("elective_course_id") Integer elective_course_id);
}
