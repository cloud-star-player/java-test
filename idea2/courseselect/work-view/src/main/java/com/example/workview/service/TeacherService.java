package com.example.workview.service;

import com.example.common.pojo.Teacher;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.TeacherServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@FeignClient(value = "adminteacher-client",fallback = TeacherServiceimpl.class)
public interface TeacherService {
    @RequestMapping(value = "/adteacher/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult elCeall(@RequestParam(defaultValue = "1")Integer page);

    @RequestMapping("/adteacher/elcdelete/{tno}")
    public @ResponseBody
    ResponseResult elCedel(@PathVariable("tno") String tno);

    @RequestMapping(value="/adteacher/elcdels/{snoList}",method= RequestMethod.POST)
    public ResponseResult elCedels(@RequestParam("snoList") List snoList);

    @RequestMapping(value="/adteacher/elcdels/update",method= RequestMethod.POST)
    public ResponseResult elCeupdate(@RequestBody Teacher teacher);

    @RequestMapping(value = "/adteacher/elcdels/add",method= RequestMethod.POST)
    public ResponseResult elCeadd(@RequestBody Teacher teacher);

    @RequestMapping(value = "/adteacher/sid/{tno}",method= RequestMethod.POST)
    public ResponseResult elCid(@PathVariable("tno") String tno);


}
