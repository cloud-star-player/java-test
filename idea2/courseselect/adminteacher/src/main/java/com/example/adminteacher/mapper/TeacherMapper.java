package com.example.adminteacher.mapper;



import com.example.common.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> sellect();
    @Insert("insert into teacher(tno,password,name,professional,sex,phone_url,college_name,type,remark) values (#{tno},#{password},#{name},#{professional},#{sex},#{phone_url},#{college},#{type},#{remark})")
    int register(Teacher teacher);
    @Update("update teacher set tno=#{tno},name=#{name},professional=#{professional},sex=#{sex},phone_url=#{phone_url},remark=#{remark} where tno=#{tno}")
    int teaupdate(Teacher teacher);
    @Delete("delete from teacher where tno=#{tno}")
    int teadel(String tno);
    @Select("select * from teacher where tno=#{tno}")
    Teacher teaselectid(String tno);
    @Delete({    "<script>"        + "delete from teacher WHERE tno in "        + "<foreach item='tno' index='index' collection='snoList' open='(' separator=',' close=')'>"        +       "#{tno}"        + "</foreach>"     +"</script>"     })
    int teadels(@Param("snoList") List snoList);
}
