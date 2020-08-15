package com.example.adminteacher.controller;

import com.example.adminteacher.service.TeacherService;
import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adteacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherservice;
    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    @ApiOperation(value="获取页数", notes="根据page获取页数的来获取数据")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<Teacher> pageResult = teacherservice.sellect(page);
        System.out.println(pageResult);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{tno}",method= RequestMethod.POST)
    @ApiOperation(value="删除数据", notes="根据删除数据")
    @ApiImplicitParam(name = "elective_course_id", value = "用户",required = true)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("tno")String tno){
        return teacherservice.teadel(tno);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除多条数据", notes="根据snoList删除多条数据")
    @ApiImplicitParam(name = "snoList", value = "用户学号集合snoList",required = true)
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return teacherservice.teadels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody Teacher teacher){
        return teacherservice.teaupdate(teacher);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody Teacher teacher){
        return  teacherservice.register(teacher);
    }

    @RequestMapping("/sid/{tno}")
    public @ResponseBody ResponseResult stuid(@PathVariable("tno")String tno){
        Teacher e=teacherservice.teaselectid(tno);
        if (e == null){
            return  ResponseResult.build(500,"失败");
        }else{
            return  ResponseResult.build(200,"成功",e);
        }
    }
}
