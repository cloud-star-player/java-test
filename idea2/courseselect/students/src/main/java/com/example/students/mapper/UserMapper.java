package com.example.students.mapper;

import com.example.common.pojo.Student;
import com.example.students.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from student where sno=#{sno} and password=#{password}")
    Student login(String sno, String password);
}
