package com.example.workview.service;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.pojo.PerformanceRule;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.PerformaceRuleServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name= "adminteacher-client",fallback = PerformaceRuleServiceimpl.class)

public interface PerformanceRuleService{
    @RequestMapping(value = "/perfor/elctalls",method= RequestMethod.POST)
    public PageResult elCeall(@RequestParam(defaultValue = "1") Integer page);

    @RequestMapping(value="/perfor/elcdelete/{performance_rule_id}",method= RequestMethod.POST)
    public ResponseResult elCedel(@PathVariable("performance_rule_id") Integer performance_rule_id);

    @RequestMapping(value="/perfor/elcdels/{snoList}",method= RequestMethod.POST)
    public ResponseResult elCedels(@RequestParam("snoList") List snoList);

    @RequestMapping(value="/perfor/update",method= RequestMethod.POST)
    public ResponseResult elCeupdate(@RequestBody PerformanceRule performanceRule);

    @RequestMapping(value = "/perfor/add",method= RequestMethod.POST)
    public ResponseResult elCeadd(@RequestBody PerformanceRule performanceRule);

    @RequestMapping(value = "/perfor/sid/{performance_rule_id}",method= RequestMethod.POST)
    public ResponseResult elCid(@PathVariable("performance_rule_id") Integer performance_rule_id);
}
