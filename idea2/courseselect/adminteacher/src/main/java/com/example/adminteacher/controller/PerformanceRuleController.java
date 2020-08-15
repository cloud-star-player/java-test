package com.example.adminteacher.controller;

import com.example.adminteacher.service.PerformanceRuleService;
import com.example.adminteacher.service.PerformanceRuleService;
import com.example.common.pojo.PerformanceRule;
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
 * @date ：Created in 2020/5/5 20:52
 */
@Api("adminteacher的选课接口")
@RestController
@RequestMapping("/perfor")
public class PerformanceRuleController {
    @Autowired
    private PerformanceRuleService performanceRuleService;

    @RequestMapping(value = "/elctalls",method= RequestMethod.POST)  //这里尽量使用PostMapping或getMapping,否则会导致文档混乱
    @ApiOperation(value="获取页数", notes="根据page获取页数的来获取数据")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public PageResult itemList(@RequestParam(defaultValue="1")Integer page){
        PageResult<PerformanceRule> pageResult = performanceRuleService.elCeall(page);
        System.out.println(pageResult);
        return pageResult;
    }
    @RequestMapping(value="/elcdelete/{performance_rule_id}",method= RequestMethod.POST)
    @ApiOperation(value="删除数据", notes="根据删除数据")
    @ApiImplicitParam(name = "performance_rule_id", value = "用户",required = true)
    public @ResponseBody
    ResponseResult eclbyid(@PathVariable("performance_rule_id")Integer performance_rule_id){
        return performanceRuleService.elCedel(performance_rule_id);
    }
    @RequestMapping(value="/elcdels/{snoList}",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除多条数据", notes="根据snoList删除多条数据")
    @ApiImplicitParam(name = "snoList", value = "用户学号集合snoList",required = true)
    public ResponseResult ecldels(@PathVariable("snoList") List snoList){
        System.out.println(snoList);
        return performanceRuleService.elCedels(snoList);
    }
    @RequestMapping(value="/update",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult eclupdate(@RequestBody PerformanceRule performancerule){
        return performanceRuleService.elCeupdate(performancerule);
    }
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult ecladd(@RequestBody PerformanceRule performancerule){
        return  performanceRuleService.elCeadd(performancerule);
    }

    @RequestMapping("/sid/{performance_rule_id}")
    public @ResponseBody ResponseResult stuid(@PathVariable("performance_rule_id")Integer performance_rule_id){
        PerformanceRule e=performanceRuleService.elCid(performance_rule_id);
        if (e == null){
            return  ResponseResult.build(500,"失败");
        }else{
            return  ResponseResult.build(200,"成功",e);
        }
    }
}
