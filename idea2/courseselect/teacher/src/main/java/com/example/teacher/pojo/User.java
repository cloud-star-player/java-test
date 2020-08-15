package com.example.teacher.pojo;

import lombok.Data;

@Data
public class User {
    private String tno;
    private String password;
    private String name;
    private String professional;
    private String sex;
    private String phone_url;
    private String college_name;
    private Integer type;
}
