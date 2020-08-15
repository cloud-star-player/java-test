package com.example.students.controller;

import com.example.common.pojo.Performance;
import com.example.common.pojo.StudentElective;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.students.service.StuStudentelectiveService;
import com.example.students.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/2 18:22
 */
@Api("adminteacher的选课接口")
@RestController
@RequestMapping("/stustudentelective")
public class StuStudentelectiveController {
    @Autowired
    private StuStudentelectiveService studentelectiveService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    @ApiOperation(value="获取页数", notes="根据page获取页数的来获取数据")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<StudentElective> pageResult = studentelectiveService.elCeall(page);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    @ApiOperation(value="删除数据", notes="根据删除数据")
    @ApiImplicitParam(name = "elective_course_id", value = "用户",required = true)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("elective_course_id")Integer elective_course_id){
        return studentelectiveService.elCedel(elective_course_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除多条数据", notes="根据snoList删除多条数据")
    @ApiImplicitParam(name = "snoList", value = "用户学号集合snoList",required = true)
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return studentelectiveService.elCedels(snoList);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody StudentElective studentelective){
        return  studentelectiveService.elCeadd(studentelective);
    }
    @RequestMapping("/sid/{student_elective_id}")
    public @ResponseBody ResponseResult stuid(@PathVariable("student_elective_id")Integer student_elective_id){
        StudentElective e=studentelectiveService.elCid(student_elective_id);
        if (e == null){
            return  ResponseResult.build(500,"失败");
        }else{
            return  ResponseResult.build(200,"成功",e);
        }
    }

    @RequestMapping(value = "/selecttive/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult elective_course_id(@PathVariable("elective_course_id")Integer elective_course_id){
        StudentElective e=studentelectiveService.elCselecttive(elective_course_id);
        if (e == null){
            return  ResponseResult.build(500,"失败");
        }else{
            return  ResponseResult.build(200,"成功",e);
        }
    }
    @RequestMapping(value = "/peralls",method= RequestMethod.POST)
    public PageResult itemLists(@RequestParam(defaultValue="1")Integer page){
        PageResult<Performance> pageResult = studentelectiveService.perforall(page);
        System.out.println(pageResult);
        return pageResult;
    }
}
