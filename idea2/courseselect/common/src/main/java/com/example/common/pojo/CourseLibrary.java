package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/1 16:48
 */
@Data
public class CourseLibrary implements Serializable {
    /**
     *主键ID
     */
    private Integer course_id;
    /**
     *课程名
     */
    private String course_name;
    /**
     *所需学院
     */
    private String college_name;
    /**
     *成绩规则id
     */
    private Integer performance_rule_id;
    /**
     *学时
     */
    private String class_hour;
    /**
     *学分
     */
    private Double credit;
    /**
     *课程组名称
     */
    private String course_group_name;
    /**
     *简介
     */
    private String introduction;
    /**
     *备注
     */
    private String remark;
}
