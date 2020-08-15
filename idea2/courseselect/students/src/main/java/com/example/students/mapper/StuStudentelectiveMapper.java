package com.example.students.mapper;


import com.example.common.pojo.ElectiveCourse;
import com.example.common.pojo.Performance;
import com.example.common.pojo.StudentElective;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuStudentelectiveMapper {
    @Select("select * from student_elective s,elective_course e,course_library c where s.elective_course_id=e.elective_course_id and c.course_id=e.course_id")
    @Results({
            @Result(property = "sno", column = "sno"),
            @Result(property = "student_elective_id", column = "student_elective_id"),
            @Result(property = "elective_course_id", column = "elective_course_id"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "student_name", column = "student_name"),
            @Result(property = "time_stamp", column = "time_stamp"),
            @Result(property = "courseLibrary.course_name", column = "course_name"),
    })
    List<StudentElective> elCeall();
    @Delete("delete from student_elective where student_elective_id=#{student_elective_id}")
    int elCedel(Integer student_elective_id);


    @Insert("insert into student_elective (student_elective_id,sno,elective_course_id,student_name,remark) values (#{student_elective_id},#{sno},#{elective_course_id},#{student_name},#{remark})")
    int elCeadd(StudentElective electivecourse);

    @Delete({    "<script>"        + "delete from student_elective WHERE student_elective_id in "        + "<foreach item='student_elective_id' index='index' collection='snoList' open='(' separator=',' close=')'>"        +       "#{student_elective_id}"        + "</foreach>"     +"</script>"     })
    int elCedels(@Param("snoList") List snoList);

    @Select("select * from student_elective where student_elective_id=#{student_elective_id}")
    StudentElective elCid(Integer student_elective_id);

    @Select("select * from student_elective where elective_course_id=#{elective_course_id}")
    StudentElective elCselecttive(Integer elective_course_id);

    @Select("select * from performance")
    List<Performance>perforall();
}
