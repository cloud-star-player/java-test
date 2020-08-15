package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    /**
     *学号
     */
    private String sno;
    /**
     *密码
     */
    private String password;
    /**
     *姓名
     */
    private String name;
    /**
     *学院
     */
    private String college_name;
    /**
     *年级
     */
    private String grade;
    /**
     *班级
     */
    private String class_name;
    /**
     *备注
     */
    private String remark;
}
