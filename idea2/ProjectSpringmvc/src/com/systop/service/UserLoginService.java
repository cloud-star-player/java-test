package com.systop.service;

import java.util.List;

import com.systop.pojo.UserLogin;

public interface UserLoginService {
	public UserLogin login(String user_code,String user_password);
	public Integer register(UserLogin userlogin);
	public List<UserLogin> userx();
}
