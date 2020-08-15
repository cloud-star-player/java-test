package com.example.workview.service;


import com.example.common.unit.ResponseResult;
import com.example.workview.service.impl.AdminServiceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.example.common.pojo.Teacher;

import java.util.List;

@FeignClient(value = "adminteacher-client",fallback = AdminServiceimpl.class)
public interface AdminService {
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public @ResponseBody
    ResponseResult login(@RequestBody Teacher teacher);

}
