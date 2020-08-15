package com.example.students.service;

import com.example.common.pojo.Student;
import com.example.students.pojo.User;

public interface UserService {
   Student login(String sno, String password);
}
