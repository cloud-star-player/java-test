package com.example.teacher.mapper;

import com.example.common.pojo.Performance;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface PerformanceMapper {
      @Select("SELECT * FROM performance p,elective_course e,performance_rule pr,course_library c WHERE p.performance_rule_id = pr.performance_rule_id AND p.elective_course_id = e.elective_course_id AND e.course_id = c.course_id")
      @Results({
              @Result(property = "performance_id", column = "performance_id"),
              @Result(property = "sno", column = "sno"),
              @Result(property = "elective_course_id", column = "elective_course_id"),
              @Result(property = "tno", column = "tno"),
              @Result(property = "performance_rule_id", column = "performance_rule_id"),
              @Result(property = "peacetime_performance", column = "peacetime_performance"),
              @Result(property = "mid_term_performance", column = "mid_term_performance"),
              @Result(property = "final_performance", column = "final_performance"),
              @Result(property = "skill_assessment", column = "skill_assessment"),
              @Result(property = "total_score", column = "total_score"),
              @Result(property = "pass_flag", column = "pass_flag"),
              @Result(property = "allow_flag", column = "allow_flag"),
              @Result(property = "remark", column = "remark"),
              @Result(property = "courseLibrary.course_name", column = "course_name"),
              @Result(property = "performanceRule.remark", column = "remark"),
      })
      List<Performance> perall();

      @Insert("insert INTO performance (tno,sno,elective_course_id,performance_rule_id,peacetime_performance,mid_term_performance,final_performance,skill_assessment,total_score,pass_flag,allow_flag,remark) values (#{tno},#{sno},#{elective_course_id},#{performance_rule_id},#{peacetime_performance},#{mid_term_performance},#{final_performance},#{skill_assessment},#{total_score},#{pass_flag},#{allow_flag},#{remark})")
      int peradd(Performance performance);

}
