package com.systop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.systop.pojo.UserLogin;

public interface UserLoginMapper {
	public UserLogin login(@Param("user_code")String user_code,@Param("user_password")String user_password);
	public Integer register(UserLogin userlogin);
	public List<UserLogin> userx();
}
