package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/1 16:39
 */
@Data
public class PerformanceRule implements Serializable {
    /**
     * 主键ID
     */
    private Integer performance_rule_id;
    /**
     *平时成绩占比
     */
    private Integer peacetime_performance_proportion;
    /**
     *期中成绩占比
     */
    private Integer mid_term_performance_proportion;
    /**
     *期末成绩占比
     */
    private Integer final_performance_proportion;
    /**
     *技能成绩占比
     */
    private Integer skill_assessment_proportion;
    /**
     *备注
     */
    private String remark;
}
