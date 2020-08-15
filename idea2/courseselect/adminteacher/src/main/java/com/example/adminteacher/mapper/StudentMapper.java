package com.example.adminteacher.mapper;

import com.example.common.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> stuselects();
    @Select("select * from student")
    List<Student> stuselect();
    @Insert("insert into student (name,pasword,college_name,grade,class_name,remark) values(#{name},#{pasword},#{college_name},#{grade},#{class_name},#{remark})")
    int stuadd(Student student);
    @Update("update student set name=#{name},college_name=#{college_name},grade=#{grade},class_name=#{class_name},remark=#{remark} where sno=#{sno}")
    int stuupdate(Student student);
    @Delete("delete from student where sno=#{sno}")
    int studel(String sno);
    @Select("select * from student where sno=#{sno}")
    Student stuselectid(String sno);
    @Delete({    "<script>"        + "delete from student WHERE sno in "        + "<foreach item='sno' index='index' collection='snoList' open='(' separator=',' close=')'>"        +       "#{sno}"        + "</foreach>"     +"</script>"     })
    int studels(@Param("snoList") List snoList);
}
