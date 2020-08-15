package com.example.workview.controller;

import com.example.common.pojo.Performance;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permance")
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/perall")
    public PageResult perall(@RequestParam(defaultValue="1")Integer page){
        PageResult<Performance> pageResult = performanceService.perall(page);
        return pageResult;
    }

    @PostMapping("/peradd")
    public  @ResponseBody
    int peradd(@RequestBody Performance performance){
        System.out.println(performance);
        return performanceService.peradd(performance);
    }
}
