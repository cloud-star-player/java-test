package com.example.workview.service.impl;

import com.example.common.pojo.PerformanceRule;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.PerformanceRuleService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/6/8 15:05
 */
@Component
public class PerformaceRuleServiceimpl implements PerformanceRuleService {
    @Override
    public PageResult elCeall(Integer page) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public ResponseResult elCedel(Integer performance_rule_id) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCeupdate(PerformanceRule performanceRule) {
        return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCeadd(PerformanceRule performanceRule) {
         return ResponseResult.build(401,"系统异常,请联系管理员");
    }

    @Override
    public ResponseResult elCid(Integer performance_rule_id) {
         return ResponseResult.build(401,"系统异常,请联系管理员");
    }
}
