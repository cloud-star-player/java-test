package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ElectiveCourse implements Serializable {
    private Integer elective_course_id;  //主键ID
    private Integer course_id;         //课程id
    private String tno;                 //老师工号
    private String college_name;       //学院
    private String restricted_grade;   //限选年级
    private String time;                 //时间
    private String know;            //小节
    private String place;            //地点
    private Integer max_number;     //最大人数
    private Integer min_number;    //最小人数
    private Integer current_number;  //当前人数
    private String remark;            //备注
    private CourseLibrary courselibrary;
    private Teacher teacher;
}
