package com.example.workview.controller;

import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/1 18:27
 */
@RestController
@RequestMapping("/adteacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<Teacher> pageResult = teacherService.elCeall(page);
        System.out.println(pageResult);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{tno}",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("tno")String tno){
        return teacherService.elCedel(tno);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult ecldels(@RequestParam("snoList") List snoList){
        System.out.println(snoList);
        return teacherService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody Teacher teacher){
        return teacherService.elCeupdate(teacher);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody Teacher teacher){
        return  teacherService.elCeadd(teacher);
    }

    @RequestMapping("/sid/{tno}")
    public @ResponseBody ResponseResult stuid(@PathVariable("tno")String tno){
            return  teacherService.elCid(tno);
    }



}
