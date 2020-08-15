package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/1 17:34
 */
@Data
public class Performance implements Serializable {
    /**
     *主键ID
     */
    private Integer performance_id;
    /**
     *学号
     */
    private String sno;
    /**
     *课程id
     */
    private Integer elective_course_id;
    /**
     *老师id
     */
    private String tno;
    /**
     *成绩规则ID
     */
    private Integer performance_rule_id;
    /**
     *平时成绩
     */
    private Double peacetime_performance;
    /**
     *期中成绩
     */
    private Double mid_term_performance;
    /**
     *期末成绩
     */
    private Double final_performance;
    /**
     *技能成绩
     */
    private Double skill_assessment;
    /**
     *总成绩
     */
    private Double total_score;
    /**
     *是否及格
     */
    private Integer pass_flag;
    /**
     *是否发布
     */
    private Integer allow_flag;
    /**
     *备注
     */
    private String remark;

    private ElectiveCourse electiveCourse;

    private PerformanceRule performanceRule;

    private CourseLibrary courseLibrary;
}
