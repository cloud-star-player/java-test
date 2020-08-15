package com.example.teacher.service.impl;

import com.example.common.pojo.Excel;
import com.example.common.pojo.Student;
import com.example.teacher.mapper.ExcelMapper;
import com.example.teacher.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/9 8:30
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private ExcelMapper excelmapper;
    @Override
    public List<Excel> stutentall() {
        return excelmapper.list();
    }
}
