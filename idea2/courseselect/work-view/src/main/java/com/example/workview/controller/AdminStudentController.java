package com.example.workview.controller;

import com.example.common.pojo.Student;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.AdminStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/3 19:58
 */
@RestController
public class AdminStudentController {
    @Autowired
    private AdminStudentService s;
    @RequestMapping(value = "/stualls")
    public ResponseResult stualls(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageResult pageResult= s.itemList(pageNum);
        if (pageResult == null){
            return ResponseResult.build(500,"失败");
        }else{
            return ResponseResult.build(200,"成功",pageResult);
        }
    }

    @RequestMapping(value="/stuadd",method= RequestMethod.POST)
    public ResponseResult stuadd(@RequestBody Student student){
        return s.stuadd(student);
    }


    @RequestMapping(value="/stuupdate",method= RequestMethod.POST)
    public ResponseResult stuupdate(@RequestBody Student student){
        return s.stuupdate(student);
    }

    @RequestMapping(value="/stuid/{sno}")
    public Student stuid(@PathVariable("sno") String sno){
        return s.stuselectid(sno);
    }

    @RequestMapping(value="/studelete/{sno}")
    public int studel(@PathVariable("sno") String sno){
        return s.studel(sno);
    }

    @RequestMapping(value="/studels/{snoList}",method= RequestMethod.POST)
    public int studels(@PathVariable("snoList") List snoList){
        return s.studels(snoList);
    }

    @RequestMapping(value="/stulogin",method= RequestMethod.POST)
    public @ResponseBody ResponseResult stulogin(@RequestBody Student student){
        return s.stulogin(student);
    }
}
