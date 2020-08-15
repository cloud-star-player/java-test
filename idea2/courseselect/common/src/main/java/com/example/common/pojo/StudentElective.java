package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：huangwei
 * @date ：Created in 2020/4/1 17:31
 */
@Data
public class StudentElective implements Serializable {
    /**
     *主键ID
     */
    private Integer student_elective_id;
    /**
     *学号
     */
    private String sno;
    /**
     *排课id
     */
    private Integer elective_course_id;
    /**
     *学生姓名
     */
    private String student_name;
    /**
     *时间戳，退课24小时后才能重新选课
     */
    private Date time_stamp;
    /**
     *备注
     */
    private String remark;

    private ElectiveCourse electiveCourse;

    private CourseLibrary courseLibrary;
}
