package com.example.adminteacher.mapper;

import com.example.common.pojo.CourseLibrary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseLibraryMapper {
        @Select("select * from course_library")
        List<CourseLibrary> elCeall();

        @Delete("delete from course_library where course_id=#{course_id}")
        int elCedel(Integer course_id);

        @Insert("insert into course_library (course_name,college_name,performance_rule_id,class_hour,credit,course_group_name,introduction,remark) values (#{course_name},#{college_name},#{performance_rule_id},#{class_hour},#{credit},#{course_group_name},#{introduction},#{remark})")
        int elCeadd(CourseLibrary courseLibrary);

        @Update("update course_library set course_name=#{course_name},college_name=#{college_name},performance_rule_id=#{performance_rule_id},class_hour=#{class_hour},credit=#{credit},course_group_name=#{course_group_name},introduction=#{introduction},remark=#{remark}")
        int elCeupdate(CourseLibrary courseLibrary);

        @Delete({    "<script>"        + "delete from course_library WHERE course_id in "        + "<foreach item='course_id' index='index' collection='snoList' open='(' separator=',' close=')'>"        +       "#{course_id}"        + "</foreach>"     +"</script>"     })
        int elCedels(@Param("snoList") List snoList);

        @Select("select * from course_library where course_id=#{course_id}")
        CourseLibrary elCid(Integer course_id);
}
