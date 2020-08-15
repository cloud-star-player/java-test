package com.systop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.systop.pojo.Customer;
import com.systop.pojo.Interview;

public interface InterviewService {
	public Interview uionselect(Integer inter_cust_id);
	public List<Interview> interviewall();
	public List<Interview> interselects();
	public Integer interviewadd(Interview in);
	public Interview interviewbyid(Integer inter_cust_id);
}
