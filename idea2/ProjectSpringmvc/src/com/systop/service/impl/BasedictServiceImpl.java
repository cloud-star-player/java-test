package com.systop.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systop.dao.BasedictMapper;
import com.systop.pojo.Basedict;
import com.systop.service.BasedictService;

@Service
@Transactional
public class BasedictServiceImpl implements BasedictService{
	@Autowired
	private BasedictMapper basedictDao;


	


	@Override
	public List<Basedict> basedictsfrom() {
		// TODO 自动生成的方法存根
		System.out.println(basedictDao.basedictsfrom());
		return basedictDao.basedictsfrom();
	}


	@Override
	public List<Basedict> basedictsindust() {
		// TODO 自动生成的方法存根
		System.out.println(basedictDao.basedictsfrom());
		return basedictDao.basedictsindust();
	}


	@Override
	public List<Basedict> basedictslevel() {
		// TODO 自动生成的方法存根
		System.out.println(basedictDao.basedictsfrom());
		return basedictDao.basedictslevel();
	}

	
}
