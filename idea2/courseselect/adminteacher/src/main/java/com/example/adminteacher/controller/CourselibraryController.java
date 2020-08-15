package com.example.adminteacher.controller;

import com.example.adminteacher.service.CourselibraryService;
import com.example.common.pojo.CourseLibrary;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
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
@RequestMapping("/course")
public class CourselibraryController {
    @Autowired
    private CourselibraryService courselibraryService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    @ApiOperation(value="获取选课页数", notes="根据page获取页数的来获取数据")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<CourseLibrary> pageResult = courselibraryService.elCeall(page);
        System.out.println(pageResult);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    @ApiOperation(value="删除数据", notes="根据删除数据")
    @ApiImplicitParam(name = "elective_course_id", value = "用户",required = true)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("elective_course_id")Integer elective_course_id){
        return courselibraryService.elCedel(elective_course_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除多条数据", notes="根据snoList删除多条数据")
    @ApiImplicitParam(name = "snoList", value = "用户学号集合snoList",required = true)
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return courselibraryService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody CourseLibrary courselibrary){
        courselibrary.
        return courselibraryService.elCeupdate(courselibrary);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody CourseLibrary courselibrary){
        return  courselibraryService.elCeadd(courselibrary);
    }

    @RequestMapping("/sid/{elective_course_id}")
    public @ResponseBody ResponseResult stuid(@PathVariable("elective_course_id")Integer elective_course_id){
        CourseLibrary e=courselibraryService.elCid(elective_course_id);
        if (e == null){
            return  ResponseResult.build(500,"失败");
        }else{
            return  ResponseResult.build(200,"成功",e);
        }
    }
}
