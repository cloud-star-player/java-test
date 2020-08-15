package com.example.workview.controller;

import com.example.common.pojo.PerformanceRule;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.PerformanceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/1 18:27
 */
@RestController
@RequestMapping("/perfor")
public class PerformanceRuleController {
    @Autowired
    private PerformanceRuleService performanceRuleService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<PerformanceRule> pageResult = performanceRuleService.elCeall(page);
        System.out.println(pageResult);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{elective_course_id}",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult eclbyid(@PathVariable("elective_course_id")Integer elective_course_id){
        return performanceRuleService.elCedel(elective_course_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult ecldels(@PathVariable("snoList") List snoList){
        System.out.println(snoList);
        return performanceRuleService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody PerformanceRule performanceRule){
        System.out.println(performanceRule);
        return performanceRuleService.elCeupdate(performanceRule);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody PerformanceRule performanceRule){
        return  performanceRuleService.elCeadd(performanceRule);
    }

    @RequestMapping(value="/sid/{elective_course_id}",method= RequestMethod.POST)
    public @ResponseBody ResponseResult stuid(@PathVariable("elective_course_id")Integer elective_course_id){
            return  performanceRuleService.elCid(elective_course_id);
    }

}
