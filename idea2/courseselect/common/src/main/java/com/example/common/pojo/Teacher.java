package com.example.common.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class Teacher implements Serializable {
    /**
     *工号
     */
    private String tno;
    /**
     *密码
     */
    private String password;
    /**
     *姓名
     */
    private String name;
    /**
     *职称
     */
    private String professional;
    /**
     *性别
     */
    private String sex;
    /**
     *照片
     */
    private String phone_url;
    /**
     *学院
     */
    private String college_name;
    /**
     *类型：0教秘1老师
     */
    private Integer type;
    /**
     *备注
     */
    private String remark;
}
