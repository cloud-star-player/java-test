package com.systop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systop.dao.InterviewMapper;
import com.systop.pojo.Interview;
import com.systop.service.InterviewService;
@Service
@Transactional
public class InterviewServiceImpl implements InterviewService{
	@Autowired
    private InterviewMapper interviewDao;
	
	@Override
	public Interview uionselect(Integer inter_cust_id) {
		// TODO �Զ����ɵķ������
		Interview inw=interviewDao.uionselect(inter_cust_id);
		return inw;
	}

	@Override
	public List<Interview> interviewall() {
		// TODO �Զ����ɵķ������
		return interviewDao.interviewall();
	}

	@Override
	public List<Interview> interselects() {
		// TODO �Զ����ɵķ������
		return interviewDao.interselects();
	}

	@Override
	public Integer interviewadd(Interview in) {
		// TODO �Զ����ɵķ������
		return interviewDao.interviewadd(in);
	}

	@Override
	public Interview interviewbyid(Integer inter_cust_id) {
		// TODO �Զ����ɵķ������
		return interviewDao.interviewbyid(inter_cust_id);
	}

	

}
