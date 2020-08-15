package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：huangwei
 * @date ：Created in 2020/5/9 9:14
 */
@Data
public class Excel implements Serializable {
    private String sno;
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

    public Excel() {

    }

    public Excel(String sno, String name, String college_name, String grade, String class_name, String remark) {
        this.sno = sno;
        this.name = name;
        this.college_name = college_name;
        this.grade = grade;
        this.class_name = class_name;
        this.remark = remark;
    }
}
