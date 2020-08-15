package com.example.teacher.service;

import com.example.common.pojo.Performance;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PerformanceService {
      PageResult<Performance> perall(int page);
      int peradd(Performance performance);
}
