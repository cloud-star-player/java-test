package com.example.adminteacher.mapper;


import com.example.common.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 登录
     * @param tno  工号
     * @param password  密码
     * @param type   类型
     * @return
     */
    @Select("select * from teacher where tno=#{tno} and password=#{password} and type=#{type}")
    Teacher login(String tno, String password, Integer type);
}
