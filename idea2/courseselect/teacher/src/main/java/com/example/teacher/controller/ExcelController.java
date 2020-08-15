package com.example.teacher.controller;



import com.example.common.pojo.Excel;
import com.example.common.unit.ExportExcelUtils;
import com.example.teacher.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @Description TODO
 * @date 2019/4/7
 * @备注
 **/
@RestController
@RequestMapping("/excel")
 public class ExcelController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ExcelService excelService;
    @RequestMapping(value = "/exportBankCheckInfo",method = RequestMethod.GET)
    public void ExportBankCkeckInfo(HttpServletResponse response, HttpServletRequest request){
        //得到所有要导出的数据
        List<Excel> orderlist =excelService.stutentall();
        //定义导出的excel名字
        String excelName = "学生详情表";
        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("sno","学号");
        fieldMap.put("name","姓名");
        fieldMap.put("college_name","学院");
        fieldMap.put("grade","年级");
        fieldMap.put("class_name","班级");
        fieldMap.put("remark","备注");
        //导出用户相关信息
        new ExportExcelUtils().export(excelName,orderlist,fieldMap,response);
    }
}

