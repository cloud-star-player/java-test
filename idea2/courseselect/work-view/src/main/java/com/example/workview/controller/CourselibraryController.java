package com.example.workview.controller;

import com.example.common.pojo.CourseLibrary;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.CourselibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/1 18:27
 */
@RestController
@RequestMapping("/course")
public class CourselibraryController {
    @Autowired
    private CourselibraryService courselibraryService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<CourseLibrary> pageResult = courselibraryService.elCeall(page);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("elective_course_id")Integer elective_course_id){
        return courselibraryService.elCedel(elective_course_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return courselibraryService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody CourseLibrary courselibrary){
        return courselibraryService.elCeupdate(courselibrary);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody CourseLibrary courselibrary){
        return  courselibraryService.elCeadd(courselibrary);
    }
    @RequestMapping("/sid/{elective_course_id}")
    public @ResponseBody ResponseResult stuid(@PathVariable("elective_course_id")Integer elective_course_id){
        return  courselibraryService.elCid(elective_course_id);
    }

}
