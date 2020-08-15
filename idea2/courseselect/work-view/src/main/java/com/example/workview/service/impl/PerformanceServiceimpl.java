package com.example.workview.service.impl;

import com.example.common.pojo.Performance;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.PerformanceService;
import org.springframework.stereotype.Component;

/**
 * @author ：huangwei
 * @date ：Created in 2020/6/11 19:34
 */
@Component
public class PerformanceServiceimpl implements PerformanceService {

    @Override
    public PageResult perall(Integer page) {
        return PageResult.build("系统异常,请联系管理员",401);
    }

    @Override
    public int peradd(Performance performance) {
        return 1;
    }
}
