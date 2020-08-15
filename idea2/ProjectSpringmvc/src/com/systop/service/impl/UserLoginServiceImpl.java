package com.systop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systop.dao.UserLoginMapper;
import com.systop.pojo.UserLogin;
import com.systop.service.UserLoginService;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserLoginMapper userLoginMapper;

	@Override
	public UserLogin login(String user_code, String user_password) {
		// TODO �Զ����ɵķ������
		UserLogin userLogin=userLoginMapper.login(user_code, user_password);
		return userLogin;
	}

	@Override
	public Integer register(UserLogin userlogin) {
		// TODO �Զ����ɵķ������
		Integer i=userLoginMapper.register(userlogin);
		return i;
	}

	@Override
	public List<UserLogin> userx() {
		// TODO �Զ����ɵķ������
		return userLoginMapper.userx();
	}
	
}
