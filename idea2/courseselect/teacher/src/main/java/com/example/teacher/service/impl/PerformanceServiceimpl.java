package com.example.teacher.service.impl;

import com.example.common.pojo.Performance;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.teacher.mapper.PerformanceMapper;
import com.example.teacher.service.PerformanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceimpl implements PerformanceService {
      @Autowired
      private PerformanceMapper performanceMapper;


      @Override
      public PageResult perall(int page) {
            PageHelper.startPage(page, 5);
            List<Performance> list = performanceMapper.perall();
            PageInfo<Performance> pageInfo = new PageInfo<Performance>(list);
            System.out.println(pageInfo+"--------------------");
            PageResult<Performance> result = new PageResult<Performance>();
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
      public int peradd(Performance performance) {

                  int i=performanceMapper.peradd(performance);

            return i;
      }
}
