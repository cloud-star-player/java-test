package com.example.adminteacher.mapper;


import com.example.common.pojo.ElectiveCourse;
import com.example.common.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ElectiveCourseMapper {
    @Select("select * from elective_course e,teacher t,course_library c where e.tno=t.tno and e.course_id=c.course_id")
    @Results({
            @Result(property = "elective_course_id", column = "elective_course_id"),
            @Result(property = "course_id", column = "course_id"),
            @Result(property = "college_name", column = "college_name"),
            @Result(property = "restricted_grade", column = "restricted_grade"),
            @Result(property = "time", column = "time"),
            @Result(property = "know", column = "know"),
            @Result(property = "place", column = "place"),
            @Result(property = "max_number", column = "max_number"),
            @Result(property = "min_number", column = "min_number"),
            @Result(property = "current_number", column = "current_number"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "courselibrary.course_name", column = "course_name"),
            @Result(property = "teacher.tno", column = "tno"),
            @Result(property = "teacher.name", column = "tno"),
    })
    List<ElectiveCourse> elCeall();

    @Delete("delete from elective_course where elective_course_id=#{elective_course_id}")
    int elCedel(Integer elective_course_id);

    @Update("update  elective_course set remark='可选' where elective_course_id=#{elective_course_id}")
    int elCupselect(Integer elective_course_id);

    @Update("update elective_course set remark='不可选' where elective_course_id=#{elective_course_id}")
    int elCnoselect(Integer elective_course_id);


    @Insert("insert into elective_course (course_id,tno,college_name,restricted_grade,time,know,place,max_number,min_number,current_number,remark) values (#{course_id},#{tno},#{college_name},#{restricted_grade},#{time},#{know},#{place},#{max_number},#{min_number},#{current_number},#{remark})")
    int elCeadd(ElectiveCourse electivecourse);

    @Update("update elective_course set course_id=#{course_id},tno=#{tno},college_name=#{college_name},restricted_grade=#{restricted_grade},time=#{time},know=#{know},place=#{place},max_number=#{max_number},current_number=#{current_number},remark=#{remark}")
    int elCeupdate(ElectiveCourse electivecourse);

    @Delete({    "<script>"        + "delete from elective_course WHERE elective_course_id in "        + "<foreach item='elective_course_id' index='index' collection='snoList' open='(' separator=',' close=')'>"        +       "#{elective_course_id}"        + "</foreach>"     +"</script>"     })
    int elCedels(@Param("snoList") List snoList);

    @Select("select * from elective_course where elective_course_id=#{elective_course_id}")
    ElectiveCourse elCid(Integer elective_course_id);
}
