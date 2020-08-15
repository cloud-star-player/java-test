package com.example.adminteacher.service;

import com.example.common.pojo.ElectiveCourse;
import com.example.common.pojo.Performance;
import com.example.common.pojo.PerformanceRule;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PerformanceRuleService {
    PageResult<PerformanceRule> elCeall(Integer page);

    ResponseResult elCedel(Integer performance_rule_id);

    ResponseResult elCeadd(PerformanceRule performanceRule);

    ResponseResult elCeupdate(PerformanceRule performanceRule);

    ResponseResult elCedels(@Param("snoList") List snoList);

    PerformanceRule elCid(Integer performance_rule_id);
}
