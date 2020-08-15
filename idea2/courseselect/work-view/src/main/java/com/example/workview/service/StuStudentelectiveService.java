package com.example.workview.service;

import com.example.common.pojo.StudentElective;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.StuStudentelectiveServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "students-client",fallback = StuStudentelectiveServiceimpl.class)
public interface StuStudentelectiveService {
    @RequestMapping(value = "/stustudentelective/elctalls",method= RequestMethod.POST)
    public PageResult elCeall(@RequestParam(defaultValue = "1") Integer page);

    @RequestMapping(value="/stustudentelective/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    public ResponseResult elCedel(@PathVariable("elective_course_id") Integer elective_course_id);

    @RequestMapping(value="/stustudentelective/elcdels/{snoList}",method= RequestMethod.POST)
    public ResponseResult elCedels(@RequestParam("snoList") List snoList);

    @RequestMapping(value="/stustudentelective/update",method= RequestMethod.POST)
    public ResponseResult elCeupdate(@RequestBody StudentElective studentelective);

    @RequestMapping(value = "/stustudentelective/add",method= RequestMethod.POST)
    public ResponseResult elCeadd(@RequestBody StudentElective studentelective);

    @RequestMapping(value = "/stustudentelective/sid/{student_elective_id}",method= RequestMethod.POST)
    public ResponseResult elCid(@PathVariable("student_elective_id") Integer student_elective_id);

    @RequestMapping(value = "/stustudentelective/peralls",method= RequestMethod.POST)
    public PageResult perforall(@RequestParam(defaultValue="1")Integer page);

    @RequestMapping(value = "/stustudentelective/selecttive/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult elective_course_id(@PathVariable("elective_course_id")Integer elective_course_id);
}
