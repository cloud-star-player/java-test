package com.example.workview.service;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.AdminServiceimpl;
import com.example.workview.service.impl.ElectiveCourseServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "adminteacher-client",fallback = ElectiveCourseServiceimpl.class)
public interface ElectiveCourseService {
    @RequestMapping(value = "/elect/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult elCeall(@RequestParam(defaultValue="1")Integer page);

    @RequestMapping("/elect/elcdelete/{elective_course_id}")
    public @ResponseBody
    ResponseResult elCedel(@PathVariable("elective_course_id")Integer elective_course_id);

    @RequestMapping(value="/elect/elcdels/{snoList}",method= RequestMethod.POST)
    public ResponseResult elCedels(@RequestParam("snoList") List snoList);

    @RequestMapping(value="/elect/update",method= RequestMethod.POST)
    public ResponseResult elCeupdate(@RequestBody ElectiveCourse electiveCourse);

    @RequestMapping(value = "/elect/add",method= RequestMethod.POST)
    public ResponseResult elCeadd(@RequestBody ElectiveCourse electiveCourse);

    @RequestMapping(value = "/elect/sid/{elective_course_id}",method= RequestMethod.POST)
    public ResponseResult elCid(@PathVariable("elective_course_id")Integer elective_course_id);

    @RequestMapping(value ="/elect/elCupselect/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult elCupselect(@PathVariable("elective_course_id")Integer elective_course_id);
    @RequestMapping(value ="/elect/elCnoselect/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult elCnoselect(@PathVariable("elective_course_id")Integer elective_course_id);
}
