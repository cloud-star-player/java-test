package com.example.workview.service;

import com.example.common.pojo.Student;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.AdminStudentServiceimpl;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "students-client",fallback = AdminStudentServiceimpl.class)
public interface AdminStudentService {
    @RequestMapping(value = "/stualls")
    public PageResult itemList(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum);

//    @RequestMapping(value = "/stuall")
//    public PageInfo stuselect(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum);

    @RequestMapping(value="/stuadd",method= RequestMethod.POST)
    public @ResponseBody ResponseResult stuadd(@RequestBody Student student);

    @RequestMapping(value="/stuupdate",method= RequestMethod.POST)
    public @ResponseBody ResponseResult stuupdate(@RequestBody Student student);

    @RequestMapping("/studelete/{sno}")
    public @ResponseBody int studel(@PathVariable("sno") String sno);

    @RequestMapping("/stuid/{sno}")
    public @ResponseBody Student stuselectid(@PathVariable("sno") String sno);

    @RequestMapping(value="/studels/{snoList}",method= RequestMethod.POST)
    public int studels(@RequestParam("snoList") List snoList);

    @RequestMapping(value="/stulogin",method= RequestMethod.POST)
    public @ResponseBody ResponseResult stulogin(@RequestBody Student student);
}
