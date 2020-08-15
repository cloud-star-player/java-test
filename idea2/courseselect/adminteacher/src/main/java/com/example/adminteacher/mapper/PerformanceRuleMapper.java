package com.example.adminteacher.mapper;


import com.example.common.pojo.Performance;
import com.example.common.pojo.PerformanceRule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PerformanceRuleMapper {
    @Select("select * from performance_rule")
    List<PerformanceRule> elCeall();


    @Delete("delete from performance_rule where performance_rule_id=#{performance_rule_id}")
    int elCedel(Integer performance_rule_id);

    @Insert("insert into performance_rule (peacetime_performance_proportion,mid_term_performance_proportion,final_performance_proportion,skill_assessment_proportion,remark) values (#{peacetime_performance_proportion},#{mid_term_performance_proportion},#{final_performance_proportion},#{skill_assessment_proportion},#{remark})")
    int elCeadd(PerformanceRule performanceRule);

    @Update("update performance_rule set peacetime_performance_proportion=#{peacetime_performance_proportion},mid_term_performance_proportion=#{mid_term_performance_proportion},final_performance_proportion=#{final_performance_proportion},skill_assessment_proportion=#{skill_assessment_proportion},remark=#{remark} where performance_rule_id=#{performance_rule_id} ")
    int elCeupdate(PerformanceRule performanceRule);

    @Delete({    "<script>"        + "delete from performance_rule WHERE performance_rule_id in "        + "<foreach item='performance_rule_id' index='index' collection='snoList' open='(' separator=',' close=')'>"        +       "#{performance_rule_id}"        + "</foreach>"     +"</script>"     })
    int elCedels(@Param("snoList") List snoList);

    @Select("select * from performance_rule where performance_rule_id=#{performance_rule_id}")
    PerformanceRule elCid(Integer performance_rule_id);
}
