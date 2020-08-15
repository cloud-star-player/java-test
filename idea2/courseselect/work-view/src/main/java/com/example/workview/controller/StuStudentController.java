package com.example.workview.controller;

import com.example.common.pojo.Performance;
import com.example.common.pojo.StudentElective;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.StuStudentelectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/1 18:27
 */
@RestController
@RequestMapping("/stustudentelective")
public class StuStudentController {
    @Autowired
    private StuStudentelectiveService stustudentelectiveService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<StudentElective> pageResult = stustudentelectiveService.elCeall(page);
        System.out.println(pageResult);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("elective_course_id")Integer elective_course_id){
        return stustudentelectiveService.elCedel(elective_course_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return stustudentelectiveService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody StudentElective studentelective){
        return stustudentelectiveService.elCeupdate(studentelective);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody StudentElective studentelective){
        return  stustudentelectiveService.elCeadd(studentelective);
    }

    @RequestMapping("/sid/{student_elective_id}")
    public @ResponseBody ResponseResult stuid(@PathVariable("student_elective_id")Integer student_elective_id){
            return  stustudentelectiveService.elCid(student_elective_id);
    }

    @RequestMapping("/selecttive/{elective_course_id}")
    public @ResponseBody ResponseResult selecttive(@PathVariable("elective_course_id")Integer elective_course_id){
        return  stustudentelectiveService.elective_course_id(elective_course_id);
    }
    @RequestMapping(value = "/peralls",method= RequestMethod.POST)
    public PageResult itemLists(@RequestParam(defaultValue="1")Integer page){
        PageResult<Performance> pageResult = stustudentelectiveService.perforall(page);
        System.out.println(pageResult);
        return pageResult;
    }
}
