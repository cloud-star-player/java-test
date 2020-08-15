package com.example.workview.controller;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.ElectiveCourseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/1 18:27
 */
@RestController
@RequestMapping("/elect")
public class ElectiveCourseController {
    @Autowired
    private ElectiveCourseService electiveCourseService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<ElectiveCourse> pageResult = electiveCourseService.elCeall(page);
        System.out.println(pageResult.getMsg());
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("elective_course_id")Integer elective_course_id){
        return electiveCourseService.elCedel(elective_course_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return electiveCourseService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody ElectiveCourse electiveCourse){
        return electiveCourseService.elCeupdate(electiveCourse);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody ElectiveCourse electiveCourse){
        return  electiveCourseService.elCeadd(electiveCourse);
    }
    @RequestMapping("/sid/{elective_course_id}")
    public @ResponseBody ResponseResult stuid(@PathVariable("elective_course_id")Integer elective_course_id){
        return  electiveCourseService.elCid(elective_course_id);
    }

    @RequestMapping(value ="/elCupselect/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult elCupselect(@PathVariable("elective_course_id")Integer elective_course_id){
        return electiveCourseService.elCupselect(elective_course_id);
    }
    @RequestMapping(value ="/elCnoselect/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult elCnoselect(@PathVariable("elective_course_id")Integer elective_course_id){
        return electiveCourseService.elCnoselect(elective_course_id);
    }
}
