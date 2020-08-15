package com.example.workview.service;

import com.example.common.pojo.Performance;
import com.example.common.unit.PageResult;
import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.AdminServiceimpl;
import com.example.workview.service.impl.PerformanceServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "teacher-client")
public interface PerformanceService {
    @PostMapping("/permance/perall")
    public PageResult perall(@RequestParam(defaultValue="1")Integer page);

    @PostMapping("/permance/peradd")
    public int peradd(@RequestBody Performance performance);
}
