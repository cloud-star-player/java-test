package com.example.teacher.mapper;

import com.example.teacher.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from teacher where tno=#{tno} and password=#{password}")
    User login(String tno, String password,Integer type);
}
