package com.example.adminteacher.service.impl;

import com.example.adminteacher.mapper.PerformanceRuleMapper;
import com.example.adminteacher.service.PerformanceRuleService;
import com.example.common.pojo.PerformanceRule;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/30 21:32
 */
@Service
@Transactional
public class PerformanceRuleServiceimpl implements PerformanceRuleService{
    @Autowired
    private PerformanceRuleMapper performanceRuleMapper;

    @Override
    public PageResult<PerformanceRule> elCeall(Integer page) {
        PageHelper.startPage(page, 5);
        List<PerformanceRule> list = performanceRuleMapper.elCeall();
        PageInfo<PerformanceRule> pageInfo = new PageInfo<PerformanceRule>(list);
        System.out.println(pageInfo+"--------------------");
        PageResult<PerformanceRule> result = new PageResult<PerformanceRule>();
        result.setData(list);    //每页的数据
        result.setCount(pageInfo.getTotal());    //总共有多少记录数
        result.setPages(pageInfo.getPages());       //总共页数
        result.setSfFirstPage(pageInfo.isIsFirstPage());//是否为第一页
        result.setSfLastPage(pageInfo.isIsLastPage());//是否为最后一页
        result.setHasNextPage(pageInfo.isHasNextPage());//是否有下一页
        result.setHasPreviousPage(pageInfo.isHasPreviousPage());//是否有上一页
        result.setFirstPage(pageInfo.getFirstPage()); //首页页码
        result.setLastPage(pageInfo.getLastPage());//尾页页码
        result.setNavigatepageNums(pageInfo.getNavigatepageNums());//所有导航页号
        result.setPageSize(pageInfo.getPageSize());//当前页面显示的数据条目
        result.setPageNum(page);           //当前页数(从1开始)
        return result;
    }

    @Override
    public ResponseResult elCedel(Integer performance_rule_id) {
        try {
            int i=performanceRuleMapper.elCedel(performance_rule_id);
        }catch (Exception e){
            return ResponseResult.build(500,"删除失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeadd(PerformanceRule performanceRule) {
        try {
            int i=performanceRuleMapper.elCeadd(performanceRule);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCeupdate(PerformanceRule performanceRule) {
        try {
            int i=performanceRuleMapper.elCeupdate(performanceRule);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult elCedels(List snoList) {
        try {
            int i=performanceRuleMapper.elCedels(snoList);
        }catch (Exception e){
            return ResponseResult.build(500,"更改失败");
        }
        return ResponseResult.ok();
    }

    @Override
    public PerformanceRule elCid(Integer performance_rule_id) {
        return performanceRuleMapper.elCid(performance_rule_id);
    }
}
