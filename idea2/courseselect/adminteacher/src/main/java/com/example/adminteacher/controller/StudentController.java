package com.example.adminteacher.controller;

import com.example.adminteacher.service.StudentService;
import com.example.common.pojo.Student;
import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/1 21:05
 */

/**
 * @Api注解可以用来标记当前Controller的功能。
 * @ApiOperation注解用来标记一个方法的作用。
 * @ApiImplicitParam注解用来描述一个参数，可以配置参数的中文含义，也可以给参数设置默认值，这样在接口测试的时候可以避免手动输入。
 * 如果有多个参数，则需要使用多个@ApiImplicitParam注解来描述，多个@ApiImplicitParam注解需要放在一个@ApiImplicitParams注解中。
 * 需要注意的是，@ApiImplicitParam注解中虽然可以指定参数是必填的，但是却不能代替@RequestParam(required = true)，
 * 前者的必填只是在Swagger2框架内必填，抛弃了Swagger2，这个限制就没用了，所以假如开发者需要指定一个参数必填，@RequestParam(required = true)注解还是不能省略。
 */
@Api("adminteacher的学生接口")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/stualls")  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    @ApiOperation(value="获取学生页数", notes="根据page获取学生页数的来获取数据")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<Student> pageResult = studentService.stuselects(page);
        System.out.println(pageResult);
        return pageResult;
    }


    @RequestMapping(value = "/stuall")
    public PageInfo stuall(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Student> list = studentService.stuselect();
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }
//    PageInfo.list	结果集
//    PageInfo.pageNum	当前页码
//    PageInfo.pageSize	当前页面显示的数据条目
//    PageInfo.pages	总页数
//    PageInfo.total	数据的总条目数
//    PageInfo.prePage	上一页
//    PageInfo.nextPage	下一页
//    PageInfo.isFirstPage	是否为第一页
//    PageInfo.isLastPage	是否为最后一页
//    PageInfo.hasPreviousPage	是否有上一页
//    PageHelper.hasNextPage	是否有下一页
    @RequestMapping("/studelete/{sno}")
    @ApiOperation(value="删除学生数据", notes="根据sno删除学生数据")
    @ApiImplicitParam(name = "sno", value = "用户sno",required = true)
    public @ResponseBody
    Integer discussbyid(@PathVariable("sno")String sno){
        return studentService.studel(sno);
    }

    @RequestMapping(value="/studels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除多条学生数据", notes="根据snoList删除多条学生数据")
    @ApiImplicitParam(name = "snoList", value = "用户学号集合snoList",required = true)
    public int studels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return studentService.studels(snoList);
    }



    @RequestMapping(value="/stuupdate",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult stuupdate(@RequestBody Student student){
        return studentService.stuupdate(student);
    }

    @RequestMapping(value = "/stuadd",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult stuadd(@RequestBody Student student){

        return  studentService.stuadd(student);
    }

    @RequestMapping("/stuid/{sno}")
    @ApiOperation(value="删除多条学生数据", notes="根据snoList查找单条学生数据")
    @ApiImplicitParam(name = "sno", value = "学号sno",required = true)
    public @ResponseBody Student stuid(@PathVariable("sno")String sno){
        return studentService.stuselectid(sno);
    }

}
